package com.mindstorm.ex04;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button b1, b2, b3, b4;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //---Action Dial button---
        b1 = (Button) findViewById(R.id.btn_makecalls1);
        b1.setOnClickListener(new OnClickListener()
        {
        public void onClick(View arg0){
	        Intent i = new Intent(android.content.Intent.ACTION_DIAL,Uri.parse("tel:+651234567"));
	        startActivity(i);
        }
        });

        //---Action Call button
        b2 = (Button) findViewById(R.id.btn_makecalls2);
        b2.setOnClickListener(new OnClickListener()
        {
        public void onClick(View arg0){
	        Intent i = new Intent(android.content.Intent.ACTION_CALL,Uri.parse("tel:+651234567"));
	        startActivity(i);
        }
        });
        
        //---Send SMS button
        b3 = (Button) findViewById(R.id.btn_sendsms);
        b3.setOnClickListener(new OnClickListener()
        {
        public void onClick(View arg0){
			Intent i = new Intent(android.content.Intent.ACTION_VIEW);
			i.putExtra("address", "9820300784;9821060381");
			i.putExtra("sms_body", "Hi. I am currently attending the Android Workshop.");
			i.setType("vnd.android-dir/mms-sms");
			startActivity(i);
        }
        });
        //---Send Email button
        b4 = (Button) findViewById(R.id.btn_sendemail);
        b4.setOnClickListener(new OnClickListener()
        {
        public void onClick(View arg0){
			Intent emailIntent = new Intent(Intent.ACTION_SEND);

			String[] to = {"romin.k.irani@gmail.com","romin.irani@mindstormsoftware.com"};
			emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
			
			//String[] cc = carbonCopies;
			//emailIntent.putExtra(Intent.EXTRA_CC, cc);
			
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reminder For Android Workshop");
			
			emailIntent.setType("text/plain");
			emailIntent.putExtra(Intent.EXTRA_TEXT, "Please note that the Android Workshop is going to be held on 6th October 2012.");
			
			startActivity(Intent.createChooser(emailIntent, "Send Email via..."));
        }
        });
    }
}
