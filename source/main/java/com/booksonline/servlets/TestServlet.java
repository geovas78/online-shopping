/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.services.HeaderPageLoginDetailsServiceImpl;
import com.booksonline.services.ProcessOrder;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        String originPage = request.getParameter("pageOrigin");
        String itemID = request.getParameter("itemID");

        String pageKids = "kids";
        String pageProfessional = "pro";
        String URLtoGo = "";

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
        req.setAttribute("itemAdded", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher(URLtoGo);
        dispatcher.forward(req, response);
        
         */
        //String page = request.getParameter("pageOrigin");
        //String id = request.getParameter("itemID");*/
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getParameter("cardNumber") + "</h1>");
            out.println("<h1>Servlet TestServlet at " + request.getParameter("name") + "</h1>");
            out.println("<h1>Servlet TestServlet at " + request.getParameter("cardCVC") + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //}
        }
    }
}
