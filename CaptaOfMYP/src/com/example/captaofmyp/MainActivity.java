package com.example.captaofmyp;

import java.util.List;
import java.util.Random;

import com.example.captamyp.ArticulosDataSource;
import com.example.captamyp.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	 private UsuariosDataSource datasource;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    datasource = new UsuariosDataSource(this);
	    datasource.open();

	    List<Usuarios> values = datasource.getAllUsuarioss();

	    // use the SimpleCursorAdapter to show the
	    // elements in a ListView
	    ArrayAdapter<Usuarios> adapter = new ArrayAdapter<Usuarios>(this,
	        android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	  }

	  // Will be called via the onClick attribute
	  // of the buttons in main.xml
	  public void onClick(View view) {
	    @SuppressWarnings("unchecked")
	    ArrayAdapter<Usuarios> adapter = (ArrayAdapter<Usuarios>) getListAdapter();
	    Usuarios usuarios = null;
	    switch (view.getId()) {
	    case R.id.text:
	      String[] usuarios = new String[] { "Raul es bueno", "Raul es malo", "Raul te pincha con su captus" };
	      int nextInt = new Random().nextInt(3);
	      // save the new comment to the database
	      usuarios = datasource.createUsuarios(usuarios[nextInt]);
	      usuarios = datasource
	      adapter.add(u);
	      break;
	    case R.id.delete:
	      if (getListAdapter().getCount() > 0) {
	        comment = (Comment) getListAdapter().getItem(0);
	        datasource.deleteComment(comment);
	        adapter.remove(comment);
	      }
	      break;
	    }
	    adapter.notifyDataSetChanged();
	  }

	  @Override
	  protected void onResume() {
	    datasource.open();
	    super.onResume();
	  }

	  @Override
	  protected void onPause() {
	    datasource.close();
	    super.onPause();
	  }

}
