/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import com.booksonline.model.Address;
import com.booksonline.model.UserLoginDetails;
import com.booksonline.services.AddressService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class AddressCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        UserLoginDetails details = (UserLoginDetails)session.getAttribute("userLoginDetails");
        AddressService addressService = new AddressService();
        Address deliveryPlace = addressService.getAddress(details.getEmail(), "delivery_address");
        Address billingPlace = addressService.getAddress(details.getEmail(), "billing_address");
        if(deliveryPlace.getEmail() == null)
        {
            ((HttpServletResponse) response).sendRedirect("/booksonline/register-address");
        }
        else
        {
            session.setAttribute("deliveryAddress", deliveryPlace);
            session.setAttribute("billingAddress", billingPlace);
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
