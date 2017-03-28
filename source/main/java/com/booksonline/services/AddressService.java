/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.Address;

/**
 *
 * @author George
 */
public class AddressService {
    
    DatabaseOperations dbOps;
    
    public Address getAddress(String email, String addressType)
    {
        dbOps = new DatabaseOperations();
        Address address = dbOps.getAddress(email, addressType);
        return address;
    }
    
    public boolean saveAddress(String email, String firstLine, String secondLine, String postcode,
            String town, String country, String mobile, String landline,String addressTypeToSave)
    {
        dbOps = new DatabaseOperations();
        boolean successful = dbOps.saveAddress(email, firstLine, secondLine, postcode, town, country, mobile, landline, addressTypeToSave);
        return successful;
    }
    
    public boolean updateAddress(String email, String firstLine, String secondLine, String postcode,
            String town, String country, String mobile, String landline,String addressTypeToSave)
    {
        dbOps = new DatabaseOperations();
        boolean successful = dbOps.updateAddress(email, firstLine, secondLine, postcode, town, country, mobile, landline, addressTypeToSave);
        return successful;
    }
    
}
