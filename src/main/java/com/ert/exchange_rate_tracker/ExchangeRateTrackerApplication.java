package com.ert.exchange_rate_tracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ert.utils.web_scrapper.Scrapper;
import com.ert.utils.email_sender.EmailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import java.io.IOException;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.ert.utils.email_sender", "com.ert.exchange_rate_tracker"})
public class ExchangeRateTrackerApplication {

	@RequestMapping(value = "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
		EmailSender sender = new EmailSender();
		sender.sendMail();
		return "Email sent successfully";
    }   
	
    @GetMapping("/")
	public String printString() throws IOException
	{
		Scrapper scrape = new Scrapper();

		return "Remitly Rate: 1 USD = " + scrape.remitlyScrape() + "<br>Xoom Rate:   " + scrape.xoomScrape();
	}

	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(ExchangeRateTrackerApplication.class, args);
	}
}
