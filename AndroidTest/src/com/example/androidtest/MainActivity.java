package com.example.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Base_Activity{
	private final String tag = this.getClass().getSimpleName();
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case R.id.twitter: 
				Log.i(tag,"Twitter item clicked");
			return true;
			
			case R.id.facebook: 
				Log.i(tag,"Facebook item clicked");
			return true;
			
			case R.id.refresh: 
				Log.i(tag,"Refresh item clicked");
			return true;
			
			default: 
				return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(tag,"onCreate()");
	}

	
	@Override
	protected void onPause() {
		Log.i(tag,"onPause()");
		// If a back button is hit, activity is paused and a different activity is brought to the foreground
		super.onPause();
	}

	@Override
	protected void onResume() {
		Log.i(tag,"onResume()");
		// TODO Auto-generated method stub
		super.onResume();
	}
	// after onResume the Activity is visible and being used
	
	public void buttonClick(View v){
		Log.i(tag,"Starting NewActivity");
		Intent intent = new Intent(this,NewActivity.class);
		intent.putExtra("screenText", "Hello World!");
		startActivity(intent);
		
	}
	@Override
	protected void onStart() {
		Log.i(tag,"onStart()");
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	

}
