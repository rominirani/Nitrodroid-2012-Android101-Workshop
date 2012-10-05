package com.mindstorm.quoteapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuotesAppActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotesappactivity);
        
        //Show Quotes Button
        Button btnShowQuotes = (Button)findViewById(R.id.btnShowQuotes);
        btnShowQuotes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),MainActivity.class);
				startActivity(intent);
			}
		});
        
        //About This App Button
        Button btnAboutApp = (Button)findViewById(R.id.btnAboutApp);
        btnAboutApp.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				QuotesAppActivity.this.showDialog();
			}
		});

    }
    public void showDialog() {
		AlertDialog dialog = new AlertDialog.Builder(this).create();
		dialog.setTitle(R.string.app_name);
		dialog.setMessage("version 1.0");
		dialog.show();
    }
}