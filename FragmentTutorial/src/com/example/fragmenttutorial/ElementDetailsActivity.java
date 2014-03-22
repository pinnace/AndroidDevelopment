package com.example.fragmenttutorial;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/*
 * ElementDetailsActivity should not be shown in landscape mode
 */

public class ElementDetailsActivity extends FragmentActivity {
	String tag = this.getClass().getSimpleName();
	@Override
	protected void onCreate(Bundle arg0) {
		Log.i(tag,"onCreate()");
		setContentView(R.layout.elements_details_activity);
		super.onCreate(arg0);
		
		//------------ Don't forget to add activity to Manifest!
		
		if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			Log.i(tag,"This method should not be called for Landscape Orientation on this device. Shutting down.");
			finish();
		}
		Intent intent = this.getIntent(); // var intent now equals whatever intent started this activity.
		Bundle element = intent.getBundleExtra("bundle");
		
		/*
		 * In this activity we have created...:
		 * 	1) Element Details Fragment to display element information when selected
		 */
		Fragment ElementDetails = new ElementsDetailFragment(); 
		ElementDetails.setArguments(element);
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.elementDetailsFrame, ElementDetails);
		transaction.commit();
	}
	

}
