package com.example.fragmenttutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends FragmentActivity implements ElementsListFragment.ElementsListClickHandler{
	String tag = this.getClass().getSimpleName();
	boolean dualPane;
	FrameLayout infoFrame;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
		Log.i(tag, "Setting content view...");
		setContentView(R.layout.activity_main);
		Log.i(tag, "Finding frame layout");
		infoFrame = (FrameLayout) findViewById(R.id.infoFrame); //test native screen resolution
		Log.i(tag, "Determining whether frame layout supports landscape");
		dualPane = (infoFrame!=null && infoFrame.getVisibility()==View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(tag, "onCreateOptionsMenu");
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onHandleElementClick(int position) { 
		
		/* built in method, called from interface ElementsListFragment.ElementsListClickHandler, 
		 * which in itself was an interface called from OnItemClickListener in ElementsListFragment.
		 * This extra complexity is so that MainActivity will control all calls to fragment activities
		 */
		Log.i(tag, "Clicked at Position: " + position);
		Bundle element = new Bundle(); //....store bundle of information you need
		element.putInt("position", position); // pass bundle into fragment
		
		/*
		 * Here is the screen supported dualPane, we created a new Fragment to be 
		 * used in ElementDetailsActivity. This was passed with FragmentTransactions
		 * which replaced the smaller layout with the larger one and then passed the information
		 * 
		 * else simply took the information from (Bundle) element, added it to an intent,
		 * and then started ElementDetailsActivity. Information contained in the bundle
		 * is simply position index for String Array held in StringArrays.xml
		 */
		
		if(dualPane){ // handles layout on large screen
			Fragment ElementDetails = new ElementsDetailFragment(); 
			// Bundle up details to pass to ElementDetailsActivity
			ElementDetails.setArguments(element);
			
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.infoFrame, ElementDetails);
			transaction.addToBackStack(null);
			transaction.commit();
		}
		else{
			Intent intent = new Intent(this, ElementDetailsActivity.class); // runtime bind b/w MainActivity and ElementDetailsActivity
			intent.putExtra("bundle", element);
			startActivity(intent);
		}
	}
	
	
	
	
	
	/*
	 * (non-Javadoc)
	 * We do not need these overridden methods if we are not changing anything (hence call to super)
	 * but the log is useful to see lifecycle.
	 
	@Override
	protected void onDestroy() {
		Log.i(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.i(tag, "onPause");
		super.onPause();
	}

	@Override
	protected void onResume() {
		Log.i(tag, "onResume");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(tag, "onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.i(tag, "onStop");
		super.onStop();
	}
	*/
	

}
