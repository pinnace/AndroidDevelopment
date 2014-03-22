package com.example.forexriskmanagementtools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Data extends FragmentActivity {
	double marketprice, marketrisk;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		
		EditText marketPrice = (EditText) findViewById(R.id.market_price);
		EditText marketRisk = (EditText) findViewById(R.id.market_risk);
		
		marketprice = Double.valueOf(marketPrice.getText().toString()).doubleValue(); 
		marketrisk = Double.valueOf(marketRisk.getText().toString()).doubleValue();
		
		if (findViewById(R.id.account_settings) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
		}
		getReadyToCalculate();
		
	}
	
	private void getReadyToCalculate(){
		
		Button buttonCalculate = (Button) findViewById(R.id.button_calculate);
		buttonCalculate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){
				Log.i("Button Message","Button Clicked");
				Toast.makeText(Data.this, "Hoorah", Toast.LENGTH_LONG).show();
			}
		});
		Intent intent = new Intent(Data.this, Calculator.class);
		intent.putExtra("MARKET_PRICE", marketprice);
		intent.putExtra("MARKET_RISK", marketrisk);
		startActivity(intent);
	
	}
}
