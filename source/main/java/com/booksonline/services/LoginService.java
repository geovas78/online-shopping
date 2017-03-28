/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.UserLoginDetails;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class LoginService {

    public boolean tryLogin(String email, String password, HttpSession session) {
        boolean match = false;
        DatabaseOperations dbOps = new DatabaseOperations();
        UserLoginDetails userDetailsDB = dbOps.getUserLoginDetails(email);

        if (userDetailsDB != null && userDetailsDB.getPassword() != null && userDetailsDB.getPassword().equals(password)) {
            synchronized (session) {
                UserLoginDetails details = (UserLoginDetails) session.getAttribute("userLoginDetails");
                if (details == null) {
                    details = new UserLoginDetails();
                    details.setEmail(email);
                    details.setPassword(password);
                    details.setFirstName(userDetailsDB.getFirstName());
                    session.setAttribute("userLoginDetails", details);
                    match = true;
                } else {
                    details.setEmail(email);
                    details.setPassword(password);
                    details.setFirstName(userDetailsDB.getFirstName());
                    session.setAttribute("userLoginDetails", details);
                    match = true;
                }
            }
        }

        return match;
    }

}
