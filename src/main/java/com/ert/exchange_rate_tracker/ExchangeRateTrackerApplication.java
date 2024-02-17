package com.ert.exchange_rate_tracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@SpringBootApplication
@RestController
public class ExchangeRateTrackerApplication {

	@GetMapping("/")
	public String printString() throws IOException{
		Scrapper scrape = new Scrapper();
		return "Remitly Rate: 1 USD = " + scrape.remitlyScrape() + "<br>Xoom Rate:   " + scrape.xoomScrape();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ExchangeRateTrackerApplication.class, args);
	}
}
