/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.Product;
import com.booksonline.model.ShoppingCartItem;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class ShoppingCartServiceImpl implements ShoppingCartService{
    
    DecimalFormat df = new DecimalFormat("######0.00");

    @Override
    public Map<List<ShoppingCartItem>, String> getAllProducts(Map<String, Integer> cart) {
        
        Map<List<ShoppingCartItem>, String> shoppingDetails = new HashMap<List<ShoppingCartItem>, String>();
        List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
        Product product;
        ShoppingCartItem item;
        DatabaseOperations dbOps = new DatabaseOperations();
        double totalCost = 0;
        
        for(String itemID : cart.keySet())
        {
            product = new Product();
            product = dbOps.getProduct(itemID);
            
            double subtotal = cart.get(itemID) * product.getProductPrice();
            totalCost = totalCost + subtotal;
            
            String price = df.format(product.getProductPrice()) + "";
            String subtotalAmount = df.format(subtotal) + "";
            
            item = new ShoppingCartItem();
            item.setItemID(product.getProductId());
            item.setItemTitle(product.getProductTitle());
            item.setSingleItemPrice(price);
            item.setNumProducts(cart.get(itemID));
            item.setSubtotalAmount(subtotalAmount);
            
            items.add(item);
        }
        String total = df.format(totalCost) + "";
        shoppingDetails.put(items, total);
        return shoppingDetails;
    }
    
    public void updateOrder(HttpSession session, String itemID, int numberOfItems)
    {
        
        synchronized(session){
            
            Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("shoppingCart");
            
            if (cart.containsKey(itemID)) {
                cart.put(itemID, numberOfItems);
            }
        }
    }
    
    public void removeOrder(HttpSession session, String itemID)
    {
        synchronized(session){
            Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("shoppingCart");
            if(cart.containsKey(itemID))
            {
                cart.remove(itemID);
            }
        }
    }
    
}
