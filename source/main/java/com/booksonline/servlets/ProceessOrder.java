/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.services.HeaderPageLoginDetailsServiceImpl;
import com.booksonline.services.ProcessOrder;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
@WebServlet(name = "ProceessOrder", urlPatterns = {"/addItem"})
public class ProceessOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String originPage = request.getParameter("pageOrigin");
        String itemID = request.getParameter("itemID");

        String pageKids = "kids";
        String pageProfessional = "pro";
        String URLtoGo = "";
        
        String pageRefresh = "";
        if(originPage.equals(pageKids))
        {
            pageRefresh = "kids-books";
        }
        if(originPage.equals(pageProfessional))
        {
            pageRefresh = "professional-books";
        }

        ProcessOrder processing = new ProcessOrder();
        processing.processingOrder(request.getSession(), itemID);

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);

        if (originPage.equals(pageKids)) {
            URLtoGo = "/WEB-INF/jsp/view/kids-books.jsp";
        }
        if (originPage.equals(pageProfessional)) {
            req.setAttribute("probooks", true);
            URLtoGo = "/WEB-INF/jsp/view/professional-books.jsp";
        }
        req.setAttribute("refresh", true);
        req.setAttribute("pageRefresh", pageRefresh);
        req.setAttribute("itemAdded", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher(URLtoGo);
        dispatcher.forward(req, response);
        
    }

}
