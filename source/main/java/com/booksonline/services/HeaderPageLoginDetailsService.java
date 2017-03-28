/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.services;

import com.booksonline.model.UserLoginDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public interface HeaderPageLoginDetailsService {
    
    HttpServletRequest getRequestProcessed(HttpServletRequest request);
    
}
