/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.services.ShoppingCartServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdateNumberOrderedItems", urlPatterns = {"/updateOrder"})
public class UpdateNumberOrderedItems extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String itemID = request.getParameter("itemID");
        int requiredNumber = 0; //this the input from the user
        //try to convert String to integer number
        try {
            requiredNumber = Integer.parseInt(request.getParameter("numNewOrder"));
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/home?page=shopping-cart");
        }
        //check if the user didn't enter negative value
        if(requiredNumber > 0){
        HttpSession session = request.getSession();
        ShoppingCartServiceImpl cartService = new ShoppingCartServiceImpl();
        cartService.updateOrder(session, itemID, requiredNumber);
        response.sendRedirect(request.getContextPath() + "/home?page=shopping-cart");
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/home?page=shopping-cart");
        }
        
    }

}
