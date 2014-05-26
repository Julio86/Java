package com.listas.listas_complejas;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class AvancedList extends ListActivity {

	
	private MyAdapter mAdapter = null;
	
	public class Node
	{
		public String mTitle;
		public String mDescription;
		public Integer mImageResource;
	}
	
	//ArrayList
	private static ArrayList<Node> mArray = new ArrayList<Node>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setData();
		mAdapter = new MyAdapter(this);
		setListAdapter(mAdapter);
		
	}
	
	
	private void setData() {
		// TODO Auto-generated method stub
		mArray.clear();
		Node mynode = new Node();
		
		//Reparciones de equipos
		
		mynode.mTitle = this.getResources().getString(R.string.title1);
		mynode.mDescription = this.getResources().getString(R.string.description1);
		mynode.mImageResource = R.drawable.r1;
		mArray.add(mynode);
		
		//Programación
		
		Node mynode2 = new Node();
		mynode2.mTitle = this.getResources().getString(R.string.title2);
		mynode2.mDescription = this.getResources().getString(R.string.description2);
		mynode2.mImageResource= R.drawable.r2;
		mArray.add(mynode2);
		
		//Administración de sistemas
		
		Node mynode3 = new Node();
		mynode3.mTitle = this.getResources().getString(R.string.title3);
		mynode3.mDescription = this.getResources().getString(R.string.description3);
		mynode3.mImageResource = R.drawable.r3;
		mArray.add(mynode3);
		
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id){
		
		Toast.makeText(this, mArray.get(position).mDescription, Toast.LENGTH_LONG).show();
		
	}

	public static class MyAdapter extends BaseAdapter
	{
		private Context mContext;
		
		public MyAdapter (Context c){
			mContext = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mArray.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mArray.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = null;
			if(convertView==null){
				//Make a new view
				LayoutInflater inflater = (LayoutInflater) mContext.
						getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    view = inflater.inflate(R.layout.main, null);
			    
			}
			else {
				// Use convertView if it is available
				view = convertView;
				
			}
			//Example to gt an image resource
			ImageView img = (ImageView) view.findViewById(R.id.image);
			img.setImageDrawable(mContext.getResources().getDrawable(mArray.get(position).mImageResource));
			
			TextView tTitle = (TextView) view.findViewById(R.id.title);
			tTitle.setText(mArray.get(position).mTitle);
			
			TextView Tdescription = (TextView) view.findViewById(R.id.description);
			Tdescription.setText(mArray.get(position).mDescription);
			
			return view;
		}
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

}
