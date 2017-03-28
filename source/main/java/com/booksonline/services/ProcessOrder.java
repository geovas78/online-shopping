/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import java.util.Hashtable;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class ProcessOrder {
    
    @SuppressWarnings("unchecked")
    public void processingOrder(HttpSession session, String itemID)
    {
        
        Map<String, Integer> cart;
        synchronized (session) {
                 
            cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
            
            if (cart == null) {
                cart = new Hashtable<String,Integer>();
                session.setAttribute("shoppingCart", cart);
            }

            if (!cart.containsKey(itemID)) {
                cart.put(itemID, 1);
            } else {
                cart.put(itemID, cart.get(itemID) + 1);
            }
        }
        
    }
    
}
