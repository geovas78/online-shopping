/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.model.Address;
import com.booksonline.model.UserLoginDetails;
import com.booksonline.services.AddressService;
import com.booksonline.services.HeaderPageLoginDetailsServiceImpl;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
@WebServlet(name = "CheckOut", urlPatterns = {"/checkout"})
public class CheckOut extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String processing = request.getParameter("processing");

        if (request.getParameter("processing") == null) {
            processing = "address";
        }

        switch (processing) {
            case "address":
                this.displayAddressSummary(request, response);
                break;
            case "shipping":
                this.displayShippingOptions(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.displayPaymentDetails(request, response);

    }

    private void displayAddressSummary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/showAddressSummary");
        dispatcher.forward(request, response);

    }

    private void displayShippingOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/shipping-options.jsp");
        dispatcher.forward(req, response);
    }

    private void displayPaymentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DecimalFormat df = new DecimalFormat("#######0.00");
        
        String shipmentOption = (String) session.getAttribute("shipmentOption");
        if (shipmentOption == null) {
            shipmentOption = "";
            session.setAttribute("shipmentOption", shipmentOption);
        }
        
        String totalCost = (String)session.getAttribute("totalCost");
        double totalD = Double.parseDouble(totalCost);
        String shippingPrice = "0.00";
        
        
        
        if(request.getParameter("shipping").equals("free"))
        {
            session.setAttribute("priceWithShipping", totalCost);
            session.setAttribute("shipmentOption", "free");
        }
        if(request.getParameter("shipping").equals("paid"))
        {
            double total = (totalD + 12.80);
            String totalFinal = df.format(total);   //String.valueOf(total));
            session.setAttribute("priceWithShipping", totalFinal);
            session.setAttribute("shipmentOption", "paid");
            shippingPrice = "12.80";
        }

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        req.setAttribute("shippingCost", shippingPrice);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/payment-details.jsp");
        dispatcher.forward(req, response);
    }

}
