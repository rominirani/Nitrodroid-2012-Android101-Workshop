package com.mindstorm.quoteapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;

public class QuoteUtility {
	public static String readQuotesDatabase(Context ctx) throws Exception {
		//Read the file and get one quote		
				InputStream input;
					input = ctx.getAssets().open("quotes.json");
					BufferedReader breader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
				    String line="";
				    StringBuffer quotecontent = new StringBuffer();
				    line = breader.readLine();
				    while(line != null)
				    {
				    	quotecontent.append(line);
				        line = breader.readLine();
				    }
				    breader.close();
				    return quotecontent.toString();
	}
	
	public static String getRandomQuote(Context ctx) {
		try {
			String quotesDB = readQuotesDatabase(ctx);
			JSONObject QuoteJSON = new JSONObject(quotesDB);
			JSONArray QuotesArray = QuoteJSON.getJSONObject("quotesdb").getJSONArray("quotes");
			int numQuotes = QuotesArray.length();
			Random random = new Random();
			int rowId = random.nextInt(numQuotes-1);
			JSONObject randomQuote = (JSONObject) QuotesArray.get(rowId);
			Quote _quote = new Quote(randomQuote.getString("id"), randomQuote.getString("who"), randomQuote.getString("what"));
			String quoteText = _quote.getWhat() + " -- " + _quote.getWho(); 
			return quoteText;
		} catch (Exception e) {
			return "Exception in reading Quotes DB. Reason : " + e.getMessage();
		}
	}

}
