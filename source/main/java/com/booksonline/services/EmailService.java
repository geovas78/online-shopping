package com.booksonline.services;

import com.booksonline.database.DatabaseOperations;
import com.booksonline.model.Address;
import com.booksonline.model.Product;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailService {
    
    private final String subject = "Order from BooksOnline";
    DecimalFormat df = new DecimalFormat("###########0.00");
    //payment details variables
    double totalOrder;
    double postage;
    double totalBeforeVAT;
    double vat;
    double total;

    public void sendEmail(String email, String name, Map<String, Integer> ordersForEmail, String shipping) {

        //get delivery address from database
        DatabaseOperations dbOps = new DatabaseOperations();
        Address address = dbOps.getAddress(email, "delivery_address");
        //this.shipping = shipping;

        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;

        // Step1
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2
        try {
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            generateMailMessage.setSubject(subject);
            String emailBody = "<html lang=en><head>\n"
                    + "<body style=\"width: 100%; margin: 0px auto;background-image:url(http://booksonline-revanger.rhcloud.com/resources/images/bg9.jpg);\">\n"
                    + "<div>\n"
                    + "<div>\n"
                    + "<div>\n"
                    + "  <div> <img src=\"http://booksonline-revanger.rhcloud.com/resources/images/banner1.jpg\" height=\"100\" style=\"width:100%;z-index: 0;\"> </div>\n"
                    + "</div>\n"
                    + "<div>\n"
                    + "  <div> <br />\n"
                    + "    <br />\n"
                    + "    <br />\n"
                    + "    <br />\n"
                    + "    <div style=\"width: 100%;float: right\">\n"
                    + "      <h1 style=\"float: right\">Order Confirmation</h1>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "  <div>\n"
                    + "    <div>\n"
                    + "      <div>\n"
                    + "        <h2><span style=\"color:#C88810; font-size:30px; font-weight:bolder\">Dear " + address.getFirstName() + "</span>,</h2>\n"
                    + "        <br />\n"
                    + "        <p style=\"font-size:18px;text-align:justify\"> Thank you for shopping with BooksOnline. Your order has been processed and will be dispatched accordingly to meet your preferred delivery date. \n"
                    + "          Your delivery date is indicated below and if you'd like to check the status of your order log into your account at <a href=\"http://booksonline-revanger.rhcloud.com\">booksonline.com</a></p>\n"
                    + "        <hr style=\"height:5px;border:none;color:#000000;background-color:#000000\">\n"
                    + "      </div>\n"
                    + "     </div>\n"
                    + "    </div>\n"
                    + "    <div>\n"
                    + "      <div style=\"width:100%;\">\n"
                    + "        <div style=\"width:50%;float:left\">\n"
                    + "          <p style=\"color:#00F\">Your parcel wil be sent to:</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + address.getFirstName() + " " + address.getLastName() + "</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + address.getFirstLine() + "\n" + address.getSecondLine() + "</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + address.getTown() + "</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + address.getPostcode() + "</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + address.getCountry() + "</p>\n"
                    + "        </div>\n"
                    + "        <div style=\"width:50%;float:right\">\n"
                    + "          <p style=\"color:#00F\">Expected delivery date:</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + deliveryDate(shipping) + "</p>\n"
                    + "          <br />\n"
                    + "          <br />\n"
                    + "          <p style=\"color:#00F\">Your delivery option:</p>\n"
                    + "          <p style=\"font-weight:900; font-size:18px\">" + deliveryProviderOption(shipping) + "</p>\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "      <br />\n"
                    + "      <br />\n"
                    + "      <br />\n"
                    + "      <br />\n"
                    + "      <div style=\"width:100%;float:left;\">\n"
                    + "        <p>\n"
                    + "        <h1 style=\"color:#C88810; font-size:24px;font-weight:bolder;margin-top:25px\">Order Details</h1>\n"
                    + "        </p>\n"
                    + "        <hr style=\"height:3px;border:none;color:#000000;background-color:#000000\">\n"
                    + "      </div>\n"
                    + "      <div style=\"width:100%;\">\n"
                    + "        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    +           makeOrderTable(ordersForEmail)
                    + "        </table>\n"
                    + "        <br />\n"
                    + "        <br />\n"
                    + "        <br />\n"
                    + "        <br />\n"
                    + "        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
                    +           makeCalcTable(shipping)
                    + "        </table>\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "  <div>\n"
                    + "    <div>\n"
                    + "      <div>\n"
                    + "        <hr style=\"height:3px;border:none;color:#000000;background-color:#000000\">\n"
                    + "        <p style=\"font-family:Georgia, 'Times New Roman', Times, serif; font-size:16px\">Designed by Georgi Vasilski ( Java Web and Software Developer ). Allrights reserved.</p>\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</div>\n"
                    + "</body></html>";
            generateMailMessage.setContent(emailBody, "text/html");
            //System.out.println("Mail Session has been created successfully..");

            // Step3
            Transport transport = getMailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com", "revanger16@gmail.com", "23eABj9qSQ");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();

        } catch (AddressException ae) {
            ae.getMessage();
        } catch (MessagingException e) {
            e.getMessage();
        }
    }

    private String deliveryDate(String shipping) {
        String deliveryDate = null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime delivery;

        if (shipping.equals("free")) {
            delivery = now.plusDays(3);
            deliveryDate = delivery.format(format);
        }
        if (shipping.equals("paid")) {
            deliveryDate = "Tommorow<p>" + now.plusDays(1).format(format) + "</p>";
        }
        return deliveryDate;
    }

    private String deliveryProviderOption(String shipping) {
        String provider = null;

        if (shipping.equals("free")) {
            provider = "Royal Mail 3-5 business days";
        }
        if (shipping.equals("paid")) {
            provider = "Courier Fast Delivery  -  next day";
        }

        return provider;
    }

    private String makeOrderTable(Map<String, Integer> ordersForEmail) {
        DatabaseOperations dbOps = new DatabaseOperations();
        String order = "";
        Product product;
        double subTotalCost = 0;
        for (String id : ordersForEmail.keySet()) {
            product = dbOps.getProduct(id);
            subTotalCost = ordersForEmail.get(id) * product.getProductPrice();
            total = total + subTotalCost;
            order = order + "<tr>\n"
                    + "            <td><img src=\"http://booksonline-revanger.rhcloud.com/resources/images/email/" + product.getProductId() + "e.jpg\"></td>\n"
                    + "            <td>" + ordersForEmail.get(id) + "</td>\n"
                    + "            <td>" + product.getProductTitle() + "</td>\n"
                    + "            <td>£ " + df.format(subTotalCost) + "</td>\n"
                    + "          </tr>\n";
        }

        return order;
    }

    private String makeCalcTable(String shipping) {
        String paymentDetails = "";
        String postage = "0.00";
        if (shipping.equals("paid")) {
            postage = "12.80";
            totalOrder = total + 12.80;
        }
        if (shipping.equals("free")) {
            postage = "0.00";
            totalOrder = total;
        }
        double vat = (totalOrder * 16) / 100;
        double priceNoVAT = totalOrder - vat;

        paymentDetails = "<tr>\n"
                + "            <td width=\"50%\" rowspan=\"6\"></td>\n"
                + "            <td>Item Subtotal:</td>\n"
                + "            <td>£ " + df.format(total) + "</td>\n"
                + "          </tr>\n"
                + "          <tr>\n"
                + "            <td>Postage:</td>\n"
                + "            <td>£ " + postage + "</td>\n"
                + "          </tr>\n"
                + "          <tr>\n"
                + "            <td>Total before VAT:</td>\n"
                + "            <td>£ " + df.format(priceNoVAT) + "</td>\n"
                + "          </tr>\n"
                + "          <tr>\n"
                + "            <td>VAT:</td>\n"
                + "            <td>£ " + df.format(vat) + "</td>\n"
                + "          </tr>\n"
                + "          <tr>\n"
                + "            <td style=\"font-weight:bold\">Order Total:</td>\n"
                + "            <td style=\"font-weight:bold\">£ " + df.format(totalOrder) + "</td>\n"
                + "          </tr>\n";

        return paymentDetails;
    }
    
}
