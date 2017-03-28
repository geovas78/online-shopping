/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.servlets;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author George
 */
@WebListener
public class Configurator implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        
        FilterRegistration.Dynamic registration = context.addFilter("authenticationFilter", new AuthenticationFilter());
        registration.addMappingForUrlPatterns(null, false, "/checkout");
        
        registration = context.addFilter("addressCheckFilter", new AddressCheckFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD), false, "/showAddressSummary");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
    }
    
}
