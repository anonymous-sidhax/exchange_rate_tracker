package com.ert.exchange_rate_tracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ert.utils.web_scrapper.Scrapper;
import com.ert.utils.check_threshold.CheckThreshold;
import com.ert.utils.email_sender.EmailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import java.io.IOException;

@SpringBootApplication
@RestController
public class ExchangeRateTrackerApplication {

	EmailSender sender = new EmailSender();
	CheckThreshold check = new CheckThreshold();

	@RequestMapping(value = "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
		sender.sendMail();
		return "Email sent successfully";
    }   
	
    @GetMapping("/")
	public String printString() throws IOException
	{
		Scrapper scrape = new Scrapper();
		if (check.mail_validate(scrape.remitlyScrape()))
		{
			sender.sendMail();
		}
		return "Remitly Rate: 1 USD = " + scrape.remitlyScrape() + "<br>Xoom Rate:   " + scrape.xoomScrape();
	}

	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(ExchangeRateTrackerApplication.class, args);
	}
}
