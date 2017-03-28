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
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class PaymentProcessService {

    DecimalFormat df = new DecimalFormat("#########0.00");

    public boolean makePayment(String cardNumber, String cvc, String name, HttpSession session) {

        //crequired objects saved in session
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
        Map<String, Integer> ordersForEmail = cart;
        String shipmentOption = (String) session.getAttribute("shipmentOption");
        UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");
        String totalCost = (String) session.getAttribute("priceWithShipping");
        boolean successful = false;
        DatabaseOperations dbOps = new DatabaseOperations();
        Address billAddress = dbOps.getAddress(details.getEmail(), "billing_address");
        try {
            String infoToSend = "88888888" + "&" + cardNumber
                    + "&" + cvc + "&" + name + "&" + totalCost + "&" + dbOps.getDate()
                    + "&" + billAddress.getFirstLine() + "&" + billAddress.getTown() + "&" + billAddress.getPostcode() + "&" + "BookStore Ltd";

            String infoCodedString = URLEncoder.encode(infoToSend, "UTF-8");

            URL url = new URL("https://webbank-gvasilski.rhcloud.com/PayGateOnline");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

            out.write("string=" + infoCodedString);
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String ok = "OK";
            String feedback;
            while ((feedback = in.readLine()) != null) {
                if (feedback.equals(ok)) {
                    dbOps.saveCardDetails(details.getEmail(), cardNumber, cvc);
                    //get the last order number and then generate the current
                    int orderNumber = dbOps.getCurrentOrderNumber(details.getEmail());
                    //create instanse of product object
                    Product product;
                    double subTotalCost = 0;
                    for (String id : cart.keySet()) {
                        product = dbOps.getProduct(id);
                        subTotalCost = cart.get(id) * product.getProductPrice();

                        dbOps.makeRecordOfOrderDB(product.getProductTitle(), String.valueOf(cart.get(id)), df.format(subTotalCost),
                                shipmentOption, details.getEmail(), totalCost, orderNumber);

                    }
                    //remove from session everything apart from user login details
                    session.removeAttribute("totalCost");
                    session.removeAttribute("shoppingCart");
                    session.removeAttribute("priceWithShipping");
                    //send a confirmation email
                    EmailService confirmEmail = new EmailService();
                    confirmEmail.sendEmail(details.getEmail(), details.getFirstName(), ordersForEmail, shipmentOption);
                    successful = true;
                } else {
                    //remove from session everything apart from user login details
                    session.removeAttribute("totalCost");
                    session.removeAttribute("shoppingCart");
                    session.removeAttribute("priceWithShipping");
                    successful = false;
                }
            }
            in.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return successful;
    }

}
