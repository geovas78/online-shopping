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
@WebServlet(name = "AddressRegistration", urlPatterns = {"/register-address"})
public class AddressRegistration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String addressToGo = request.getParameter("address");

        if (request.getParameter("address") == null) {
            addressToGo = "dafault";
        }

        switch (addressToGo) {
            case "delivery":
                this.showDeliveryRegForm(request, response);
                break;
            case "billing":
                this.showBillingRegForm(request, response);
                break;
            default:
                this.showRegForm(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kindOfAddress = request.getParameter("address");

        if (request.getParameter("address") == null) {
            kindOfAddress = "default";
        }

        switch (kindOfAddress) {
            case "delivery":
                this.updateDeliveryAddress(request, response);
                break;
            case "billing":
                this.updateBillingAddress(request, response);
                break;
            default:
                this.saveBothAddress(request, response);
                break;
        }

    }

    private void updateDeliveryAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");

        String email = details.getEmail();
        String firstLine = request.getParameter("first_line");
        String secondLine = request.getParameter("second_line");
        String town = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        String country = request.getParameter("country");
        String mobile = request.getParameter("mobile");
        String landline = request.getParameter("landline");

        AddressService addressService = new AddressService();
        boolean deliveryAddressOK = addressService.updateAddress(email, firstLine, secondLine, postcode, town, country, mobile, landline, "delivery_address");
        
        //save both addresses into the session object
        Address deliveryPlace = addressService.getAddress(details.getEmail(), "delivery_address");
        session.setAttribute("deliveryAddress", deliveryPlace);
        if(request.getParameter("page-origin").equals("my-account"))
        {
            response.sendRedirect("/booksonline/my-account?page=personal");
        }
        else
        {
            response.sendRedirect("/booksonline/checkout?processing=address");
        }
    }

    private void updateBillingAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");

        String email = details.getEmail();
        String firstLine = request.getParameter("first_line");
        String secondLine = request.getParameter("second_line");
        String town = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        String country = request.getParameter("country");
        String mobile = request.getParameter("mobile");
        String landline = request.getParameter("landline");

        AddressService addressService = new AddressService();
        boolean billingAddressOK = addressService.saveAddress(email, firstLine, secondLine, postcode, town, country, mobile, landline, "billing_address");
        
        //save the address into the session object
        Address billingPlace = addressService.getAddress(details.getEmail(), "billing_address");
        session.setAttribute("billingAddress", billingPlace);

        if(request.getParameter("page-origin").equals("my-account"))
        {
            response.sendRedirect("/booksonline/my-account?page=personal");
        }
        else
        {
            response.sendRedirect("/booksonline/checkout?processing=address");
        }
    }

    private void saveBothAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");

        //get all the parameters from the request
        String email = details.getEmail();
        String firstLine = request.getParameter("first_line");
        String secondLine = request.getParameter("second_line");
        String town = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        String country = request.getParameter("country");
        String mobile = request.getParameter("mobile");
        String landline = request.getParameter("landline");

        //save both addresses into the database
        AddressService addressService = new AddressService();
        boolean deliveryAddressOK = addressService.saveAddress(email, firstLine, secondLine, postcode, town, country, mobile, landline, "delivery_address");
        boolean billingAddressOK = addressService.saveAddress(email, firstLine, secondLine, postcode, town, country, mobile, landline, "billing_address");

        //save both addresses into the session object
        Address deliveryPlace = addressService.getAddress(details.getEmail(), "delivery_address");
        Address billingPlace = addressService.getAddress(details.getEmail(), "billing_address");
        session.setAttribute("deliveryAddress", deliveryPlace);
        session.setAttribute("billingAddress", billingPlace);

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);

        if (deliveryAddressOK == true && billingAddressOK == true) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/address-summary.jsp");
            dispatcher.forward(req, response);
        } else {
            response.sendRedirect("/WEB-INF/jsp/view/address-register.jsp");
        }
    }

    private void showDeliveryRegForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        req.setAttribute("kindOfAddress", "DELIVERY ADDRESS");
        req.setAttribute("direction", "/register-address?address=delivery");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/address-register.jsp");
        dispatcher.forward(req, response);
    }

    private void showBillingRegForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        req.setAttribute("kindOfAddress", "BILLING ADDRESS");
        req.setAttribute("direction", "/register-address?address=billing");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/address-register.jsp");
        dispatcher.forward(req, response);
    }

    private void showRegForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("kindOfAddress", "DELIVERY ADDRESS");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/address-register.jsp");
        dispatcher.forward(req, response);
    }
}
