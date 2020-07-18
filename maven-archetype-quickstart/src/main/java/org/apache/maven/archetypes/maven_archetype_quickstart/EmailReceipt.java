package org.apache.maven.archetypes.maven_archetype_quickstart;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class EmailReceipt{  
 public static void sentMail(final String user,final String password,String to){  
  
   
  //1) get the session object     
  Properties properties = System.getProperties();  
  properties.setProperty("mail.transport.protocol", "smtp");     
  properties.setProperty("mail.host", "smtp.gmail.com");  
  properties.put("mail.smtp.auth", "true");  
  properties.put("mail.smtp.port", "465");  
  properties.put("mail.debug", "true");  
  properties.put("mail.smtp.socketFactory.port", "465");  
  properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
  properties.put("mail.smtp.socketFactory.fallback", "false");
  
  Session session = Session.getDefaultInstance(properties,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(user,password);  
   }  
  });  
     
  //2) compose message     
  try{  
    MimeMessage message = new MimeMessage(session);  
    message.setFrom(new InternetAddress(user));  
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    message.setSubject("Salary Slip @ SenSei Technology");  
      
    //3) create MimeBodyPart object and set your message text     
    BodyPart messageBodyPart1 = new MimeBodyPart();  
    messageBodyPart1.setText("This is message body");  
      
    //4) create new MimeBodyPart object and set DataHandler object to this object      
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
  
    String filename = "src/main/resources/EmployeeReport.pdf";//change accordingly  
    DataSource source = new FileDataSource(filename);  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(filename);  
     
     
    //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  
  
    //6) set the multiplart object to the message object  
    message.setContent(multipart );  
     
    //7) send message  
    Transport.send(message);  
   
   System.out.println("message sent....");  
   }catch (MessagingException ex) {ex.printStackTrace();}  
 }  
}