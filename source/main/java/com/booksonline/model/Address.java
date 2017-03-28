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
public class Address implements Serializable{
    
    private String email;
    private String firstName;
    private String lastName;
    private String firstLine;
    private String secondLine;
    private String postcode;
    private String town;
    private String country;
    private String mobile;
    private String landline;
    
    public void setAddress(String email, String firstName, String lastName, String firstLine, String secondLine, String postcode,
            String town, String country,String mobile, String landline)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postcode = postcode;
        this.town = town;
        this.country = country;
        this.mobile = mobile;
        this.landline = landline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }
    
}
