package com.mindstorm.ex03;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class Activity1 extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        
        Button btnLaunchActivity2 = (Button) findViewById(R.id.btnLaunchActivity2);
        btnLaunchActivity2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    Intent i = new Intent(getBaseContext(),Activity2.class);
			    startActivity(i);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
}
