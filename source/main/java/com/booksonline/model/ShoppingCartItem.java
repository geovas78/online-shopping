/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.model;

/**
 *
 * @author George
 */
public class ShoppingCartItem {
    
    private String itemID;
    private String itemTitle;
    private String singleItemPrice;
    private String subtotalAmount;
    private int numProducts;

    public int getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(int numProducts) {
        this.numProducts = numProducts;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getSingleItemPrice() {
        return singleItemPrice;
    }

    public void setSingleItemPrice(String singleItemPrice) {
        this.singleItemPrice = singleItemPrice;
    }

    public String getSubtotalAmount() {
        return subtotalAmount;
    }

    public void setSubtotalAmount(String subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }  
}
