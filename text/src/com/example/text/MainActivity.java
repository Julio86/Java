package com.example.text;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText imputUsuario;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Crear nuevo objeto QuotesDataSource
		@SuppressWarnings("unused")
		final EditText imputUsuario = (EditText) findViewById(R.id.editText1);
		final EditText imputPass = (EditText) findViewById(R.id.Contrasena); 
		TextView loginErrorMsg = (TextView) findViewById(R.id.login_error);
		Button btlogin = (Button) findViewById(R.id.btnLogin);
	      btlogin.setOnClickListener(new View.OnClickListener() {
	    	  
	            public void onClick(View view) {
	                String usuario = imputUsuario.getText().toString();
	                String password = imputPass.getText().toString();
	                
	                Usuarios usuario1 = new Usuarios();
	                
	                usuario.setOnLoginUsuario(new OnLoginUsuario() {
	     @Override
	     public void onLoginWrong(String msg) {loginErrorMsg.setText(msg);}
	     @Override
	     public void onLoginCorrect(JSONObject json, String msg) {
	      loginErrorMsg.setText("");
	      Intent itemintent = new Intent(Login.this, ActivityPrincipal.class);
	  Login.this.startActivity(itemintent);
	     }
	    });                
	                usuario.login(Login.this, email, password);
	            }
	        });
	        
	        lblGotoRegister = (TextView) findViewById(R.id.link_to_register);
	        lblGotoRegister.setOnClickListener(new OnClickListener() {
	   @Override
	   public void onClick(View v) {Intent itemintent = new Intent(Login.this, Register.class);
	  Login.this.startActivity(itemintent);}
	  });
	    }
		UsuariosDataSource dataSource = new UsuariosDataSource(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
