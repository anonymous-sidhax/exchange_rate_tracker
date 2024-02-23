package com.ert.utils.email_sender;

import java.util.Date;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {

	public static void sendEmail(Session session, String toEmail, String fromEmail, String charSet, String subject, String body)
    {
        try
	    {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(fromEmail, "NoReply-ERT"));
            msg.setReplyTo(InternetAddress.parse(toEmail, false));
            msg.setSubject(subject, charSet);
            msg.setText(body, charSet);
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            
            Transport.send(msg);  
	    }
	    catch (Exception e) 
        {
	      e.printStackTrace();
	    }
	}
}