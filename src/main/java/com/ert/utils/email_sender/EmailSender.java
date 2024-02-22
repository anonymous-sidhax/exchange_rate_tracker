package com.ert.utils.email_sender;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ert.utils.misc.GetDateTime;

@Component
public class EmailSender 
{
	@Value("${email.password}")
	private String password;

    public void sendMail()
    {
        
        final String fromEmail = "siddesh.0798@gmail.com";
		final String toEmail = "siddesh.shewde@gmail.com";
		final String charSet = "UTF-8";

		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() 
        {
			protected PasswordAuthentication getPasswordAuthentication() 
            {
				return new PasswordAuthentication(fromEmail, "bhsc lqau kcbh qgvp");
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail, fromEmail, charSet, "Exchange Rate Tracker: " + new GetDateTime().getDateTime(), "Test Email for Exchange Rate Tracker");
    }
}