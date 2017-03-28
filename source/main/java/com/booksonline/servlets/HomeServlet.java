/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.model.ShoppingCartItem;
import com.booksonline.services.HeaderPageLoginDetailsServiceImpl;
import com.booksonline.services.ProcessOrder;
import com.booksonline.services.ShoppingCartServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getParameter("page");

        if (request.getParameter("page") == null) {
            page = "menu";
        }

        switch (page) {
            case "menu":
                this.showMainPage(request, response);
                break;
            case "kids-books":
                this.showKidsBooks(request, response);
                break;
            case "professional-books":
                this.showProfessionalBooks(request, response);
                break;
            case "shopping-cart":
                this.showShoppingCart(request, response);
                break;
            case "authentication":
                this.showRegisterOrLogin(request, response);
                break;
            default:
                this.showMainPage(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/home.jsp");
        dispatcher.forward(req, response);
    }

    private void showKidsBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/kids-books.jsp");
        dispatcher.forward(req, response);
    }

    private void showProfessionalBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        req.setAttribute("probooks", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/professional-books.jsp");
        dispatcher.forward(req, response);
    }

    private void showShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
        if (cart == null) {
            cart = new Hashtable<String, Integer>();
            session.setAttribute("shoppingCart", cart);
        }
        ShoppingCartServiceImpl cartService = new ShoppingCartServiceImpl();
        Map<List<ShoppingCartItem>, String> allItemsOrderedAndTotal = cartService.getAllProducts(cart);
        List<ShoppingCartItem> listItems = new ArrayList<>();
        String totalPrice = "0.00";
        for (List<ShoppingCartItem> item : allItemsOrderedAndTotal.keySet()) {
            listItems = item;
            totalPrice = allItemsOrderedAndTotal.get(item);
        }
        session.setAttribute("totalCost", totalPrice);
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        req.setAttribute("listItems", listItems);
        //req.setAttribute("totalCost", totalPrice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/shopping-cart.jsp");
        dispatcher.forward(req, response);

    }

    private void showRegisterOrLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view/authentication.jsp");
        dispatcher.forward(req, response);
    }

}
