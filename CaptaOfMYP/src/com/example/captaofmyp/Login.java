package com.example.captaofmyp;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputUser;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        inputUser = (EditText) findViewById(R.id.txtUserName);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                String user = inputUser.getText().toString();
                String password = inputPassword.getText().toString();
                
            }  
        });
    }
                
              /*  user.setOnLoginUsuario(new OnLoginUsuario() {
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
    }*/
 
}
