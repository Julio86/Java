package com.example.listas_simples;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends ListActivity {

	private String[] testValues = new String[] {
	      "URJC",
	      "EOI",
	      "Android"
	};
	private ListView lvl = null;
	private ListAdapter lal = null;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		lvl = (ListView)findViewById(android.R.id.list);
		
		lal = new ArrayAdapter<String>(this,
										android.R.layout.simple_list_item_1, testValues	);
		lvl.setAdapter(lal);
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id){
		
		Toast.makeText(this, testValues[position], Toast.LENGTH_SHORT).show();
		
	}
}
