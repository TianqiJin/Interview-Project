package com.example.bookkeeping;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class History extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_history);
		
		TextView today_income_overview=(TextView)findViewById(R.id.today_income_overview);
		TextView today_payment_overview=(TextView)findViewById(R.id.today_payment_overview);
		SharedPreferences infos_income=getSharedPreferences("info_income",0);
		SharedPreferences infos_payment=getSharedPreferences("info_payment",0);
		today_income_overview.setText(infos_income.getString("amount",null)+" "+infos_income.getString("name", null));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
