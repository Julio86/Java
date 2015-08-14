package com.example.hellolayouts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {

	private TextView tvName = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellolayouts);
		tvName = (TextView) this.findViewById(R.id.name);
		
		
		
		Button btLocalizame = (Button) this.findViewById(R.id.btLocalizame);
		btLocalizame.setOnClickListener(myListener);
		Button btActualizar = (Button) this.findViewById(R.id.btActualizar);
		btActualizar.setOnClickListener(myListener2);
		
		
	}
	
	OnClickListener myListener = new OnClickListener(){
		@Override
		public void onClick (View v){
			tvName.setText("Hola Mundo");
		}
	};
	OnClickListener myListener2 = new OnClickListener(){


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tvName.setText("Nombre de usuario"); 
			
		}
	};
	
	
	
	

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_hello_layouts, menu);
		return true;
	}*/

}
