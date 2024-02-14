package com.ert.exchange_rate_tracker;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scrapper 
{
    String remitlyURL = "https://www.remitly.com/us/en/india/pricing";
    String remitlyRate = "";

    public String scrape() throws IOException
    {
        Document doc = Jsoup.connect(remitlyURL).get();
        Elements h2 = doc.getElementsByClass("f1xrk329");
        remitlyRate = h2.last().text();

        return remitlyRate;
    }
}
