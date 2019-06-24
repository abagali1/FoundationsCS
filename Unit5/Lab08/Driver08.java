	//M. Billington
	//version 6.5.2004

import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Address;
public class Driver08
{
   public static void main(String[] args) throws Exception
   {
      String address = JOptionPane.showInputDialog("Enter an email address");
      EMail em = new EMail(address);
        // JOptionPane.showMessageDialog(null, em.toString());
         
      String to = em.toString();
      String from = "a.bagali815703@gmail.com";
      String host = "localhost";
         
      Properties properties = System.getProperties();
         
      properties.setProperty("mail.smtp.host",host);
      
      Session session = Session.getDefaultInstance(properties);
      
      try{
         MimeMessage message = new MimeMessage(session);
         
         message.setFrom(new InternetAddress(from));
         
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
                
         message.setSubject("Java Emailing");
         
         message.setText("Can I get extra credit for Lab08?");
         
         Transport.send(message);
         System.out.println("Message sent!");
      }catch(Exception e){
         e.printStackTrace();
      }
   }
    
}