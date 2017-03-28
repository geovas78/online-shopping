package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.Order;
import java.util.ArrayList;

public class OrderService {

    public String getOrdersListTable(String email) {
        String orderList = "";
        DatabaseOperations dbOps = new DatabaseOperations();
        ArrayList<Order> booksList = dbOps.getListOfOrders(email);
        //create a variable to control the presentation entity
        int orderNumberLocal = 0;
        //get the end  of the list
        int endList = booksList.size();
        //put the table end tag if there's no match
        boolean endTag = false;
        int i = 0;

        for (Order order : booksList) {
            //decrease the endList
            endList--;

            if (orderNumberLocal != order.getOrderNumber()) {
                //endTag =  "</table><hr />";
                endTag = true;
            }
            if (i == 0) {
                //the first row of the table
                orderNumberLocal = order.getOrderNumber();
                //i = 1;
                endTag = false;
                GetOrderStatus status = new GetOrderStatus();

                orderList = "<table>\n"
                        + "                                <tr>\n"
                        + "                                    <th><span id=\"thead\">ITEM</span></th>\n"
                        + "                                    <th><span id=\"thead\">NUMBER</span></th>\n"
                        + "                                    <th><span id=\"thead\">AMOUNT</span></th>\n"
                        + "                                    <th><span id=\"thead\">DATE OF PURCHASE</span></th>\n"
                        + "                                    <th><span id=\"thead\">STATUS</span></th>\n"
                        + "                                    <th><span id=\"thead\">TOTAL</span></th>\n"
                        + "                                </tr>\n"
                        + "                                <tr>\n"
                        + "                                    <th>" + order.getBookName() + "</th>\n"
                        + "                                    <td>" + order.getNumberOfItems() + "</td>\n"
                        + "                                    <td>£ " + order.getSubTotal() + "</td>\n"
                        + "                                    <td rowspan=\"6\">" + order.getDate() + "</td>\n"
                        + "                                    <td rowspan=\"6\">" + status.getStatus(order.getDate(), order.getShippingOption()) + "</td>\n"
                        + "                                    <td rowspan=\"6\">£ " + order.getTotalAmount() + "</td>\n"
                        + "                                </tr>";
            }
            if (endTag == true && i == 1 && orderNumberLocal != order.getOrderNumber()) {
                //put the end tag of the table
                orderList = orderList + "</table>\n"
                        + "                            <hr />";
            }
            if (i == 1) {
                if (orderNumberLocal == order.getOrderNumber()) {
                    //second part of the table row
                    orderList = orderList + "<tr>\n"
                            + "                                <th>" + order.getBookName() + "</th>\n"
                            + "                                <td>" + order.getNumberOfItems() + "</td>\n"
                            + "                                <td>£ " + order.getSubTotal()+ "</td>\n"
                            + "                            </tr>";
                } else {
                    //first part of the table
                    orderNumberLocal = order.getOrderNumber();
                    endTag = false;
                    GetOrderStatus status = new GetOrderStatus();

                    orderList = orderList + "<table>\n"
                            + "                                <tr>\n"
                            + "                                    <th><span id=\"thead\">ITEM</span></th>\n"
                            + "                                    <th><span id=\"thead\">NUMBER</span></th>\n"
                            + "                                    <th><span id=\"thead\">AMOUNT</span></th>\n"
                            + "                                    <th><span id=\"thead\">DATE OF PURCHASE</span></th>\n"
                            + "                                    <th><span id=\"thead\">STATUS</span></th>\n"
                            + "                                    <th><span id=\"thead\">TOTAL</span></th>\n"
                            + "                                </tr>\n"
                            + "                                <tr>\n"
                            + "                                    <th>" + order.getBookName() + "</th>\n"
                            + "                                    <td>" + order.getNumberOfItems() + "</td>\n"
                            + "                                    <td>£ " + order.getSubTotal() + "</td>\n"
                            + "                                    <td rowspan=\"6\">" + order.getDate() + "</td>\n"
                            + "                                    <td rowspan=\"6\">" + status.getStatus(order.getDate(), order.getShippingOption()) + "</td>\n"
                            + "                                    <td rowspan=\"6\">£ " + order.getTotalAmount() + "</td>\n"
                            + "                                </tr>";
                }
            }
            if (endTag == true) {
                //put the end tag for the table
                orderList = orderList + "</table>\n"
                        + "                            <hr />";
            }
            if (endList == 0) {
                orderList = orderList + "</table>\n"
                        + "                            <hr />";
            }
            
            //set i to 1
            i = 1;
        }

        return orderList;
    }

}
