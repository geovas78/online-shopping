/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.services.ShoppingCartServiceImpl;
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
@WebServlet(name = "RemoveProduct", urlPatterns = {"/removeOrder"})
public class RemoveProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String itemID = request.getParameter("itemID");
        HttpSession session = request.getSession();
        ShoppingCartServiceImpl cartService = new ShoppingCartServiceImpl();
        cartService.removeOrder(session, itemID);
        response.sendRedirect(request.getContextPath() + "/home?page=shopping-cart");
    }

}
