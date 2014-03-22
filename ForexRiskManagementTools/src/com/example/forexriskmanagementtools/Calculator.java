package com.example.forexriskmanagementtools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


@SuppressLint("NewApi")
public class Calculator extends Activity {
	double marketPrice, marketRisk;
	String tag = this.getClass().getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(tag,"onCreate() Calculator");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
		Intent intent = getIntent();
		startActivity(intent);
		marketPrice  = intent.getDoubleExtra("MARKET_PRICE", -1);
		marketRisk  = intent.getDoubleExtra("MARKET_RISK", -1);
		
		setContentView(R.layout.activity_data);


	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}
	@Override
	protected void onStart(){
		Log.i(tag,"onStart() Calculator");
		super.onStart();

		
		
	}
	public void buttonClick(View v){
		Log.i(tag,"onClick() Calculator");
		double market_price = 0;
		String mpr;
		EditText mp = (EditText) findViewById(R.id.market_price);
		mpr = mp.getText().toString();
		try{
			market_price = Double.parseDouble(mpr);
		}
		catch(Exception e){
			Log.i(tag,"Error, unable to parse double. Trying to parse as Integer.");
			try{
				if(mpr!=""){
					market_price = Integer.parseInt(mpr);
				}
				else{
					market_price = 0;
				}
			}
			catch(Exception f){
				String msg;
				msg = "There was an exception again: " + f.getMessage();
				Log.i(tag,msg);
				
			}
		}
		final EditText lotSize = (EditText) findViewById(R.id.lot_size);
		if(market_price>0) lotSize.setText(Double.toString(market_price)); else lotSize.setText("market price undefined");

	}
	@Override
	protected void onDestroy() {
		Log.i(tag,"onDestroy() Calculator");
		super.onDestroy();
	}
	@Override
	protected void onPause() {
		Log.i(tag,"onPause() Calculator");
		super.onPause();
	}
	@Override
	protected void onRestart() {
		Log.i(tag,"onRestart() Calculator");
		super.onRestart();
	}
	@Override
	protected void onResume() {
		Log.i(tag,"onResume() Calculator");
		super.onResume();
	}
	@Override
	protected void onStop() {
		Log.i(tag,"onStop() Calculator");
		super.onStop();
	}
	

}
