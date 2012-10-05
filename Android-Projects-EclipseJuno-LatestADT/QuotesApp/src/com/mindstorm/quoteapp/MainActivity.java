package com.mindstorm.quoteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Display the first random quote on Activity Creation
        showRandomQuote();
        
        //Next Button
        Button btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//showToast("Get Next Quote");
				showRandomQuote();
			}
		});
        
        //SMS Quote Button
        Button btnSMS = (Button)findViewById(R.id.btnSMS);
        btnSMS.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//showToast("Launch SMS App");
				Intent i = new Intent(android.content.Intent.ACTION_VIEW);
				i.putExtra("address", "<PutNumber>");
				i.putExtra("sms_body", QuoteUtility.getRandomQuote(getBaseContext()));
				i.setType("vnd.android-dir/mms-sms");
				startActivity(i);
			}
		});

        //Email Quote Button
        Button btnEmail = (Button)findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//showToast("Launch Email App");
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nice Quote");
				emailIntent.setType("text/plain");
				emailIntent.putExtra(Intent.EXTRA_TEXT, QuoteUtility.getRandomQuote(getBaseContext()));
				startActivity(Intent.createChooser(emailIntent, "Send Email via..."));

			}
		});

    }
    private void showRandomQuote() {
        //Get the First Random Quote and show it
        String quote = QuoteUtility.getRandomQuote(this);
        TextView tv = (TextView)findViewById(R.id.txtQuote);
        tv.setText(quote);
	}
	
    private void showToast(String msg) {
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
