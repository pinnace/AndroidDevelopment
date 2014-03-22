package com.example.androidtest;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class Base_Activity extends Activity {
	String tag = this.getClass().getSimpleName();
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
}
