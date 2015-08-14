package com.example.parsenoticias;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ParseNoticiasActivity extends ListActivity {

	private MyAdapter mAdapter = null;
	 public static List<Noticia> noticias = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RssParseSax saxparser = new RssParseSax("http://www.europapress.es/rss/rss.aspx");
		noticias = saxparser.parse();
		mAdapter = new MyAdapter(this);
		setListAdapter(mAdapter);
	}
	public static class MyAdapter extends BaseAdapter{

		private Context mContext;
		
		public MyAdapter (Context c)
		{
			mContext=c;
			
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return noticias.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return noticias.get(position);
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
			    view = inflater.inflate(R.layout.activity_parse_noticias, null);
			    
			}
			else {
				// Use convertView if it is available
				view = convertView;
				
			}
			TextView tTitle = (TextView) view.findViewById(R.id.title);
			tTitle.setText(noticias.get(position).getTitulo());
			
			TextView Tdescription = (TextView) view.findViewById(R.id.description);
			Tdescription.setText(noticias.get(position).getDescripcion());
			
			TextView Tlink = (TextView) view.findViewById(R.id.link);
			Tlink.setText(noticias.get(position).getLink());
			
			/*TextView Tguid = (TextView) view.findViewById(R.id.guid);
			Tguid.setText(noticias.get(position).getGuid());*/
			TextView Tfecha = (TextView) view.findViewById(R.id.fecha);
			Tfecha.setText(noticias.get(position).getFecha());
			
			return view;
		}
		
		
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_parse_noticias, menu);
		return true;
	}*/

}
