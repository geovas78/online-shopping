package com.booksonline.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


public class GetOrderStatus {
    
    private String status = null;

    public String getStatus(String dateIn, String shippingOpt) {
        
            //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();//current date

            //convert the string from database to a date object to get the date of purchase
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //String dateInString = dateDb;//date of purchase string
            Date date = null;

            try {
                date = formatter.parse(dateIn);
            } catch (ParseException e) {
            }
            //convert the date to a LocalDateTime object for comparison
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDateTime dateOfPurchase = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

            //create the delivery date
            int daysForDelivery = 5 ;
            
            if(shippingOpt.equals("free"))
            {
                daysForDelivery = 3;
            }
            if(shippingOpt.equals("paid"))
            {
                daysForDelivery = 1;
            }
            
            LocalDateTime deliveryDate = dateOfPurchase.plusDays(daysForDelivery);

            if (deliveryDate.isBefore(now)) {
                status = "Delivered";
            } else {
                status = "In Transit";
            }
        return status;
    }
    
}
