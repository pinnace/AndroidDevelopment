package com.example.fragmenttutorial;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ElementsListFragment extends Fragment implements OnItemClickListener{
	String tag = this.getClass().getSimpleName();
	ListView elementsList;
	ArrayAdapter<String> adapter;
	Context context;
	ElementsListClickHandler handler;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i(tag, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		context = getActivity();
		View view;
		view = inflater.inflate(R.layout.elements_list_fragment, container, false);
		
		String[] elements = context.getResources().getStringArray(R.array.ElementsArray);
		
		elementsList = (ListView) view.findViewById(R.id.elementsList);
		adapter = new ArrayAdapter<String>(context, R.layout.elements_row_layout, R.id.elementsListText, elements);
		
		elementsList.setAdapter(adapter);
		elementsList.setOnItemClickListener(this); // "this" activity is an OnItemClickListener because it implements it
		Log.i(tag, "Returning view for activity" + context.getApplicationInfo());
		return view;
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
			Log.i(tag,"Trying to getActivity for ElementsListClickHandler");
			handler = (ElementsListClickHandler) getActivity();
		}
		catch(ClassCastException e){
			Log.i(tag,"Activity " + getActivity().getClass().getSimpleName()+" does not implement the ElementsListClickHandler");
		}
	}
	public interface ElementsListClickHandler{ 
		//cleaner way of doing things. the handler communicates with the
	  	// main activity on click (where the main activity makes the final
	  	// action decision) instead of the click calling a fragment sub-activity

		public void onHandleElementClick(int position);
		
		// when we click an element we will call a method from within the main activity (which will be this interface)
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Log.i(tag,"Clicked at position " + position);
		handler.onHandleElementClick(position);
	}
	
	
	/*
	 * (non-Javadoc)
	 * We do not need these overridden methods if we are not changing anything (hence call to super)
	 * but the log is useful to see lifecycle.
	 
	 
	 @Override
	public void onAttach(Activity activity) {
		Log.i(tag, "onAttach");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onDestroy() {
		Log.i(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.i(tag, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		Log.i(tag, "onDetach");
		super.onDetach();
	}

	@Override
	public void onPause() {
		Log.i(tag, "onPause");
		super.onPause();
	}

	@Override
	public void onResume() {
		Log.i(tag, "onResume");
		super.onResume();
	}

	@Override
	public void onStart() {
		Log.i(tag, "onStart");
		super.onStart();
	}

	@Override
	public void onStop() {
		Log.i(tag, "onStop");
		super.onStop();
	}
	*/


	
}
