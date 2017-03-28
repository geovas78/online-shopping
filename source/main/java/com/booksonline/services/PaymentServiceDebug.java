/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.Address;
import com.booksonline.model.Product;
import com.booksonline.model.UserLoginDetails;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class PaymentServiceDebug {
    
    DecimalFormat df = new DecimalFormat("#########0.00");

    public void makePayment(String cardNumber, String cvc, String name, HttpSession session,HttpServletRequest request, HttpServletResponse response) {

        //crequired objects saved in session
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
        Map<String, Integer> ordersForEmail = cart;
        String shipmentOption = (String) session.getAttribute("shipmentOption");
        UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");
        String totalCost = (String) session.getAttribute("priceWithShipping");
        boolean successful = false;
        DatabaseOperations dbOps = new DatabaseOperations();
        Address billAddress = dbOps.getAddress(details.getEmail(), "billing_address");
        
            String infoToSend = "88888888" + "&" + cardNumber
                    + "&" + cvc + "&" + name + "&" + totalCost + "&" + dbOps.getDate()
                    + "&" + billAddress.getFirstLine() + "&" + billAddress.getTown() + "&" + billAddress.getPostcode() + "&" + "BookStore Ltd";
           

            System.out.println(infoToSend);
            
    }
}
