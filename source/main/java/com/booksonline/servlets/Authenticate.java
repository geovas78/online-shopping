/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.services.AuthenticationServiceImpl;
import com.booksonline.services.HeaderPageLoginDetailsServiceImpl;
import com.booksonline.services.LoginService;
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
@WebServlet(name = "Authenticate", urlPatterns = {"/authenticate"})
public class Authenticate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/authentication.jsp");
        dispatcher.forward(req, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option = request.getParameter("option");
        if (request.getParameter("option") == null) {
            option = "default";
        }

        switch (option) {
            case "register-email":
                this.emailRegistration(request, response);
                break;
            case "user-registration":
                this.registerUser(request, response);
                break;
            case "login":
                this.login(request, response);
                break;
            default:
                this.showRegistrationPage(request, response);
                break;
        }

    }

    private void emailRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        AuthenticationServiceImpl authService = new AuthenticationServiceImpl();
        boolean okToRegister = authService.checkRegistrationOfEmail(request.getParameter("email"));
        if (okToRegister) {
            HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
            HttpServletRequest req = headerInfo.getRequestProcessed(request);
            req.setAttribute("homeButton", true);
            req.setAttribute("email", email);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/register.jsp");
            dispatcher.forward(req, response);
        } else {
            HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
            HttpServletRequest req = headerInfo.getRequestProcessed(request);
            req.setAttribute("homeButton", true);
            req.setAttribute("RegistrationStatus", true);
            req.setAttribute("message", "GIVEN EMAIL IS ALREADY IN OUR DATABASE, TRY LOGIN INSTEAD OR REGISTER WITH ANOTHER EMAIL");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/authentication.jsp");
            dispatcher.forward(req, response);
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginService loginService = new LoginService();
        boolean loginStatus = loginService.tryLogin(request.getParameter("email"), request.getParameter("password"), session);
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        if (loginStatus == true) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/home.jsp");
            dispatcher.forward(req, response);
        } else {
            req.setAttribute("registerFail", true);
            req.setAttribute("message", "LOGIN FAIL - EMAIL OR PASSWORD INCORRECT");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/authentication.jsp");
            dispatcher.forward(req, response);
        }
    }

    private void showRegistrationPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/authentication.jsp");
        dispatcher.forward(req, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseOperations dbOps = new DatabaseOperations();
        boolean ok = dbOps.saveUserDetailsDB(request.getParameter("id_gender"),
                request.getParameter("customer_firstname"), request.getParameter("customer_lastname"),
                request.getParameter("email-db"), request.getParameter("passwd"));

        HeaderPageLoginDetailsServiceImpl headerInfo = new HeaderPageLoginDetailsServiceImpl();
        HttpServletRequest req = headerInfo.getRequestProcessed(request);
        req.setAttribute("homeButton", true);
        if (ok == true) {
            req.setAttribute("registerOK", true);
            req.setAttribute("message", "CONRATULATIONS ! NOW YOU CAN LOG INTO YOUR ACCOUNT");
        } else {
            req.setAttribute("registerFail", true);
            req.setAttribute("message", "SORRY ! REGISTRATION FAILED ! ");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/view/authentication.jsp");
        dispatcher.forward(req, response);
    }

}
