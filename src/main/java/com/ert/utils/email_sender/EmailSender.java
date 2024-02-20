package com.ert.utils.email_sender;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

public class EmailSender
{
    public void sendMail()
    {
        
        final String fromEmail = "siddesh.0798@gmail.com";
		final String password = "";
		final String toEmail = "siddesh.shewde@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() 
        {
			protected PasswordAuthentication getPasswordAuthentication() 
            {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"Exchange Rate Tracker", "Test Email for Exchange Rate Tracker");
    }
}