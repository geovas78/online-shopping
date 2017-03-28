/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.model;

import java.io.Serializable;

/**
 *
 * @author George
 */
public class UserLoginDetails implements Serializable{
    
    private String email;
    private String firstName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return (email);
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getFirstName()
    {
        return (firstName);
    }
    
}
