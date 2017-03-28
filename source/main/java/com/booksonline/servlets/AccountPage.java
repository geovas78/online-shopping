/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.Address;
import com.booksonline.model.CreditCardDetails;
import com.booksonline.model.UserLoginDetails;
import com.booksonline.services.AddressService;
import com.booksonline.services.HeaderPageLoginDetailsServiceImpl;
import com.booksonline.services.OrderService;
import java.io.IOException;
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
@WebServlet(name = "AccountPage", urlPatterns = {"/my-account"})
public class AccountPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getParameter("page");

        if (request.getParameter("page") == null) {
            page = "default";
        }

        switch (page) {
            case "personal":
                this.showMyAccountDetailsPage(request, response);
                break;
            case "orders":
                this.showOrdersPage(request, response);
                break;
            default:
                this.goToHomePage(request, response);
                break;
        }

    }

    private void showMyAccountDetailsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserLoginDetails details = (UserLoginDetails)session.getAttribute("userLoginDetails");
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        //get the username which is the email
        req.setAttribute("username", details.getEmail());
        //get the both addresses
        AddressService addressService = new AddressService();
        Address deliveryAddress = addressService.getAddress(details.getEmail(), "delivery_address");
        Address billingAddress = addressService.getAddress(details.getEmail(), "billing_address");
        //get credit card details
        DatabaseOperations dbOps = new DatabaseOperations();
        CreditCardDetails cardDetails = dbOps.getCardDetails(details.getEmail());
        // add attributes to be sent to the jsp
        req.setAttribute("deliveryAddress", deliveryAddress);
        req.setAttribute("billingAddress", billingAddress);
        if(cardDetails.getCardNumber() == null && cardDetails.getCvc() == null)
        {
            String noRecord = "NO RECORD";
            cardDetails.setCardDetails(noRecord, noRecord);
            req.setAttribute("cardDetails", cardDetails);
        }
        else
        {
            req.setAttribute("cardDetails", cardDetails);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/account-details-page.jsp");
        dispatcher.forward(req, response);
    }

    private void showOrdersPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");
        //get the list of orders
        OrderService orderService = new OrderService();
        String orderList = orderService.getOrdersListTable(details.getEmail());
        //prepare the view
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        req.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/orders-page.jsp");
        dispatcher.forward(req, response);
    }

    private void goToHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/home.jsp");
        dispatcher.forward(req, response);
    }

}
