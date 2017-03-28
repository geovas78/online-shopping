/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.model.UserLoginDetails;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class HeaderPageLoginDetailsServiceImpl implements HeaderPageLoginDetailsService{
    
    private String getUserName(HttpSession session) {
        String name = null;
        UserLoginDetails details = (UserLoginDetails)session.getAttribute("userLoginDetails");
        if(details != null)
        {
            name = details.getFirstName();
        }
        
        return name;
    }

    private int getNumberOfOrders(HttpSession session) {
        
        int numberOfProducts = 0;
        
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
        
        if(cart != null)
        {
            for(String item : cart.keySet())
            {
                numberOfProducts = numberOfProducts + cart.get(item);
            }
        }
        
        return numberOfProducts;
        
    }
    
    @Override
    public HttpServletRequest getRequestProcessed(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (getUserName(session) != null) {
            request.setAttribute("logged", true);
            request.setAttribute("name", getUserName(session));
            request.setAttribute("numberOfProducts", getNumberOfOrders(session));
            return request;
        } else {
            request.setAttribute("logged", false);
            request.setAttribute("numberOfProducts", getNumberOfOrders(session));
            return request;
        }
    }
    
}
