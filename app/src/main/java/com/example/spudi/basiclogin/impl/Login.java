package com.example.spudi.basiclogin.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spudi.basiclogin.R;


/**
 * Created by spudi on 20-Feb-17.
 */

public class Login extends Activity {

    Button loginbutton;


    String usernametxt;
    String passwordtxt;

    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from login.xml
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginbutton = (Button) findViewById(R.id.login);

        // Login Button Click Listener
        loginbutton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Retrieve the text entered from the EditText
                        usernametxt =   username.getText().toString();
                        passwordtxt = password.getText().toString();
                        // Force user to fill up the form
                        if (usernametxt.equals("") || passwordtxt.equals("")) {
                            Toast.makeText(getApplicationContext(),
                                    "Please enter the credentials",
                                    Toast.LENGTH_LONG).show();

                        }else{
                            //Login with the credentials

                            //TODO implement actual login()

                            // If user exist and authenticated, send user to LoginSuccess.class
                            Intent intent = new Intent(Login.this, LoginSuccess.class);
                            //Passing current user info to target activity
                            intent.putExtra("currentUserName",usernametxt);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),
                                    "Login success",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                }
        );

    }
}
