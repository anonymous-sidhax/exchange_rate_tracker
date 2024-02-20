package com.ert.utils.web_scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scrapper 
{
    String remitlyURL = "https://www.remitly.com/us/en/india/pricing";
    String remitlyRate = "";
    String riaURL = "https://www.riamoneytransfer.com/en-us/send-money-to-india";
    String riaRate = "";
    String xoomURL = "https://www.xoom.com/india/send-money";
    String xoomRate = "";

    public String remitlyScrape() throws IOException
    {
        Document doc = Jsoup.connect(remitlyURL).get();
        Elements h2 = doc.getElementsByClass("f1xrk329");
        remitlyRate = h2.last().text();

        return remitlyRate;
    }
    
    public String xoomScrape() throws IOException
    {
        Document doc = Jsoup.connect(xoomURL).get();
        Elements element = doc.getElementsByClass("xvx-text-right xvx-font-copy");
        
        riaRate = element.text();

        return riaRate;
    }
}
