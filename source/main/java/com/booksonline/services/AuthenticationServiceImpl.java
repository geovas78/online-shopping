/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;

/**
 *
 * @author George
 */
public class AuthenticationServiceImpl {
    
    public boolean checkRegistrationOfEmail(String email)
    {
        boolean ok = true;
        DatabaseOperations dbOps = new DatabaseOperations();
        
        if(email.equals(dbOps.checkEmailIfExist(email)))
        {
            ok = false;
        }
        
        return ok;
        
    }
    
}
