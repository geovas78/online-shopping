/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksonline.database;

import com.booksonline.model.Address;
import com.booksonline.model.CreditCardDetails;
import com.booksonline.model.Order;
import com.booksonline.model.Product;
import com.booksonline.model.UserLoginDetails;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author George
 */
public class DatabaseOperations {

    private final DatabaseConnection connect = new DatabaseConnection();
    private final Connection conn = connect.getDBConnection();

    DecimalFormat df = new DecimalFormat("######0.00");

    public Product getProduct(String itemID) {
        Product product = new Product();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT Id,Book_title,Product_price FROM productinfo WHERE Id = '" + itemID + "'";

            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                product.setProductId(result.getString("Id"));
                product.setProductTitle(result.getString("Book_title"));
                product.setProductPrice(result.getDouble("Product_price"));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return product;
    }

    public String checkEmailIfExist(String email) {
        String emailDB = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT Email FROM accounts WHERE Email = '" + email + "'";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                emailDB = result.getString("Email");
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return emailDB;
    }

    public boolean saveUserDetailsDB(String title, String firstName, String lastName, String email, String password) {
        boolean done = false;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO accounts(Title,First_name,Last_Name,Email,Password)"
                    + "VALUES ('" + title + "','" + firstName + "','" + lastName + "','" + email + "','"
                    + password + "')";
            int result = stmt.executeUpdate(sql);
            if (result > 0) {
                done = true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return done;
    }

    public UserLoginDetails getUserLoginDetails(String email) {
        UserLoginDetails details = null;
        Statement stmt = null;
        try {
            details = new UserLoginDetails();
            stmt = conn.createStatement();
            String sql = "SELECT Email,Password,First_name FROM accounts WHERE Email = '" + email + "'";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                details.setEmail(result.getString("Email"));
                details.setPassword(result.getString("Password"));
                details.setFirstName(result.getString("First_name"));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return details;
    }

    public Address getAddress(String email, String addressType) {
        Address address = null;
        Statement stmt = null;
        try {
            String emailDB = null;
            String firstName = null;
            String lastName = null;
            String firstLine = null;
            String secondLine = null;
            String postcode = null;
            String town = null;
            String country = null;
            String mobile = null;
            String landline = null;
            address = new Address();
            stmt = conn.createStatement();
            String sql = "SELECT First_name,Last_Name FROM accounts WHERE Email = '" + email + "'";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                firstName = result.getString("First_name");
                lastName = result.getString("Last_Name");
            }
            String addressDB = "SELECT Email,First_Line,Second_line,PostCode,Town,"
                    + "Country,Mobile,Landline FROM " + addressType + " WHERE Email = '" + email + "'";
            ResultSet addressResult = stmt.executeQuery(addressDB);
            while (addressResult.next()) {
                emailDB = addressResult.getString("Email");
                firstLine = addressResult.getString("First_Line");
                secondLine = addressResult.getString("Second_Line");
                postcode = addressResult.getString("Postcode");
                town = addressResult.getString("Town");
                country = addressResult.getString("Country");
                mobile = addressResult.getString("Mobile");
                landline = addressResult.getString("Landline");
            }
            if (email != null) {
                address.setAddress(emailDB, firstName, lastName, firstLine, secondLine, postcode, town, country, mobile, landline);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return address;
    }

    public boolean saveAddress(String email, String firstLine, String secondLine, String postcode,
            String town, String country, String mobile, String landline, String addressTypeToSave) {
        boolean recorded = false;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO " + addressTypeToSave + "(Email,First_Line,Second_line,Postcode,Town,"
                    + "Country,Mobile,Landline)"
                    + "VALUES ('" + email + "','" + firstLine + "','" + secondLine + "','" + postcode + "','"
                    + town + "','United Kingdom','" + mobile + "','" + landline + "')";
            int result = stmt.executeUpdate(sql);
            if (result > 0) {
                recorded = true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return recorded;
    }

    public boolean updateAddress(String email, String firstLine, String secondLine, String postcode,
            String town, String country, String mobile, String landline, String addressTypeToSave) {
        boolean recorded = false;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE " + addressTypeToSave + " SET First_Line='" + firstLine + "', Second_line='" + secondLine + "', "
                    + "Postcode='" + postcode + "', Town='" + town + "', Country='United Kingdom', Mobile='"
                    + mobile + "', Landline='" + landline + "' WHERE Email = '" + email + "'";
            int result = stmt.executeUpdate(sql);
            if (result > 0) {
                recorded = true;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return recorded;
    }

    public void makeRecordOfOrderDB(String title, String numberOfItems, String amount, String shipmentOption,
            String email, String total, int orderNumber) {
        Statement stmt = null;
        try {

            stmt = conn.createStatement();

            String sql = "INSERT INTO recordorder (BookName,NumberOfItems,Subtotal,Date,ShippingOption,"
                    + "TotalAmount,Email,OrderNumber)"
                    + "VALUES ('" + title + "','" + numberOfItems + "','" + amount + "','" + this.getDate() + "','"
                    + shipmentOption + "','" + total + "','" + email + "'," + orderNumber + ")";
            int result = stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void saveCardDetails(String email, String cardNumber, String cvc)
    {
        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            String sql = "INSERT INTO creditcarddetails (Email,CardNumber,CVC)"
                    + "VALUES ('" + email + "','" + cardNumber + "','" + cvc + "')";
            int result = stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public CreditCardDetails getCardDetails(String email)
    {
        CreditCardDetails cardDetails = null;
        Statement stmt = null;
        
        try {

            cardDetails = new CreditCardDetails();
            stmt = conn.createStatement();
            String billadd = "SELECT * FROM creditcarddetails WHERE Email = '" + email + "'";
            ResultSet res = stmt.executeQuery(billadd);
            while (res.next()) {
                String cardNumber = res.getString("CardNumber");
                String cvc = res.getString("CVC");
                cardDetails.setCardDetails(cardNumber, cvc);
            }

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return cardDetails;
    }
    
    public int getCurrentOrderNumber(String email)
    {
        Statement stmt = null;
        int lastOrder = 1;
        
        try {

            stmt = conn.createStatement();
            //get the last order number from the database
            String getLastValue = "SELECT * FROM recordorder WHERE Email = '" + email + "' ORDER BY OrderNumber DESC LIMIT 1;";
            ResultSet res = stmt.executeQuery(getLastValue);
            while (res.next()) {
                String lastOrderStr = res.getString("OrderNumber");
                if(lastOrderStr == null)
                {
                    lastOrder = 1;
                }
                else
                {
                    lastOrder = Integer.parseInt(lastOrderStr) + 1;
                }
            }

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return lastOrder;
    }
    
    public ArrayList<Order> getListOfOrders(String email)
    {
        ArrayList<Order> listBooks = new ArrayList<>();
        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            String sql = "SELECT * FROM recordorder WHERE Email = '" + email + "' ORDER BY OrderNumber DESC";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Order order = new Order();
                order.setBookName(result.getString("BookName"));
                order.setNumberOfItems(result.getString("NumberOfItems"));
                order.setSubTotal(result.getString("Subtotal"));
                order.setDate(result.getString("Date"));
                order.setShippingOption(result.getString("ShippingOption"));
                order.setTotalAmount(result.getString("TotalAmount"));
                order.setOrderNumber(result.getInt("OrderNumber"));
                
                //add the oreder object to the collection list
                listBooks.add(order);
            }

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return listBooks;
    }
    
    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
