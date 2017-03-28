package com.booksonline.model;

import java.io.Serializable;

/**
 *
 * @author George
 */
public class CreditCardDetails implements Serializable{
    
    private String cardNumber;
    private String cvc;
    
    public void setCardDetails(String cardNumber, String cvc)
    {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
    
    
    
}
