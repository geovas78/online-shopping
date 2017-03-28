/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.model.ShoppingCartItem;
import java.util.List;
import java.util.Map;

/**
 *
 * @author George
 */
public interface ShoppingCartService {
    
    public Map<List<ShoppingCartItem>, String> getAllProducts(Map<String, Integer> cart);
    
}
