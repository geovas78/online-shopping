/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class DatabaseConnection {
    
    private final String URLdb = "jdbc:mysql://localhost:3306/bookstore_online";
    private final String userDB = "root";
    private final String passwordDB = "gogo";

    public Connection getDBConnection() {
        
        Connection connection = null;
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URLdb, userDB, passwordDB);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
}
