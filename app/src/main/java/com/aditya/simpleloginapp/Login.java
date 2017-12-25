package com.aditya.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView attempts;
    private Button login_btn;
    private int attempts_counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton();
    }

    public void loginButton(){
        username = (EditText)findViewById(R.id.editText_username);
        password = (EditText)findViewById(R.id.editText_password);
        attempts = (TextView) findViewById(R.id.editText_attempts_count);
        login_btn = (Button)findViewById(R.id.button_login);
        attempts.setText(Integer.toString(attempts_counter));
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")){
                    Toast.makeText(Login.this, "Username and Password is correct",
                            Toast.LENGTH_SHORT).show();
                    try{
                        Intent intent = new Intent("com.aditya.simpleloginapp.User");
                        startActivity(intent);
                    }catch (Exception e){
                        Log.e("Intent",e.getMessage());
                    }
               }
               else{
                    Toast.makeText(Login.this, "Username and Password is not correct", Toast.LENGTH_SHORT).show();
                    attempts_counter--;
                    attempts.setText(Integer.toString(attempts_counter));
                    if(attempts_counter==0)
                        login_btn.setEnabled(false);
               }
            }
        });
    }
}