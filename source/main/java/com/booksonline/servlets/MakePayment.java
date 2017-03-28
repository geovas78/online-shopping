/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.services.PaymentProcessService;
import com.booksonline.services.PaymentServiceDebug;
import java.io.IOException;
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
@WebServlet(name = "MakePayment", urlPatterns = {"/process-payment"})
public class MakePayment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //controlling the redirect variable
        HttpSession session = request.getSession();
        boolean entry = false;
        session.setAttribute("entry", entry);
        response.sendRedirect("connect-bank.jsp");
        String cardNumber = request.getParameter("cardNumber");
        String nameOnCard = request.getParameter("name");
        String cvc = request.getParameter("cardCVC");

        PaymentServiceDebug debug = new PaymentServiceDebug();
        debug.makePayment(cardNumber, cvc, nameOnCard, session, request, response);
        
        PaymentProcessService payment = new PaymentProcessService();

        boolean paymentSucceed = payment.makePayment(cardNumber, cvc, nameOnCard, session);
        if(paymentSucceed == true)
        {
            session.setAttribute("paymentStatus", true);
        }
        else
        {
            session.setAttribute("paymentStatus", false);
        }
        entry = true;
        session.setAttribute("entry", entry);

    }
}
