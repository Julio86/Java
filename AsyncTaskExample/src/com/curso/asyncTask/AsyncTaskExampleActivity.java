package com.curso.asyncTask;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.curso.asincTask.rssParser.GeoRSSNode;
import com.curso.asincTask.rssParser.GeoRssParser;
import com.curso.asynctaskexample.R;

public class AsyncTaskExampleActivity extends ListActivity {

	private static ArrayList<GeoRSSNode> mArray = new ArrayList<GeoRSSNode>();
	private MyAdapter adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		GeoRssParser myRssParser = new GeoRssParser();
		try{
			mArray = myRssParser.parseGeoRssURL("http://earthquake.usgs.gov/earthquakes/catalogs/eqs7day-M5.xml");
		}
		catch (ParserConfigurationException e){
			e.printStackTrace();}
		catch (SAXException e){
			e.printStackTrace();}
		catch (IOException e){
			e.printStackTrace();}
			
		}
	
	public class MyAdapter extends BaseAdapter
	{
		private Context mContext;
		public MyAdapter(Context context)
		{
			mContext = context;
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
			img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.earth));
			
			TextView tTitle = (TextView) view.findViewById(R.id.title);
			tTitle.setText(mArray.get(position).getmTitle());
			
			TextView Tdescription = (TextView) view.findViewById(R.id.description);
			Tdescription.setText(mArray.get(position).getmDescription());
			
			return view;
		}
	}
	
	


	}


