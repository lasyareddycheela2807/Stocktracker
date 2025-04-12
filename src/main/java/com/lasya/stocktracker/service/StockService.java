//package com.lasya.stocktracker.service;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class StockService {
//
//    // Simple method returning a hardcoded stock price
//    public double getStockPrice(String symbol) {
//        System.out.println("Received request for stock: " + symbol);  // Debug log
//        return 101.50;  // Hardcoded stock price for testing
//    }
//}













//
//package com.lasya.stocktracker.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.json.JSONObject;
//
//@Service
//public class StockService {
//    private static final String API_URL = "https://finnhub.io/api/v1/quote?symbol=";
//    private static final String API_KEY = "cvnaoj1r01qq3c7e5rogcvnaoj1r01qq3c7e5rp0"; // Replace with your API key
//
//    public double getStockPrice(String symbol) {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = API_URL + symbol + "&token=" + API_KEY;
//
//            // Fetch JSON response
//            String response = restTemplate.getForObject(url, String.class);
//            JSONObject json = new JSONObject(response);
//
//
//            return json.getDouble("c");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return -1; // Return -1 if fetching fails
//        }
//    }
//}





//package com.lasya.stocktracker.service;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import org.jsoup.nodes.Element;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StockService {
//
//    public double getStockPrice(String symbol) {
//        try {
//            String url = "https://finance.yahoo.com/quote/" + symbol+"/";
//            Document doc = Jsoup.connect(url).get();
//
//            // Select the price element (you might need to tweak this selector if Yahoo changes it)
//            Element priceElement = doc.selectFirst("fin-streamer[data-field=regularMarketPrice]");
//            if (priceElement != null) {
//                String priceText = priceElement.text().replace(",", "");
//                return Double.parseDouble(priceText);
//            } else {
//                System.out.println("Price element not found!");
//                return -1;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }
//}




package com.lasya.stocktracker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class StockService {

    public double getStockPrice(String symbol) {
        try {
            String url = "https://finance.yahoo.com/quote/" + symbol;
            Document doc = Jsoup.connect(url).get();

            // ✅ Save HTML to a local file
            String filePath = "C:\\Users\\lasya\\OneDrive\\Desktop\\yahoo_html_\\" + symbol + ".html";
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(doc.outerHtml());
                System.out.println("HTML saved to: " + filePath);
            }

            // Try to extract price as usual
            Element priceElement = doc.selectFirst("span[data-testid=qsp-price]");
            if (priceElement != null) {
                String priceText = priceElement.text().replace(",", "");
                return Double.parseDouble(priceText);
            } else {
                System.out.println("Price element not found!");
                return -1;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
