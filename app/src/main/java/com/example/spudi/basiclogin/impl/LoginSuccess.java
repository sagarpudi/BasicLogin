package com.example.spudi.basiclogin.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spudi.basiclogin.MainActivity;
import com.example.spudi.basiclogin.R;
import com.example.spudi.basiclogin.utils.AuthenticationUtils;

/**
 * Created by spudi on 20-Feb-17.
 */

public class LoginSuccess extends Activity {

    Button logout;

    private String userName;

    public String getUserName() {
        return userName;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);


        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);

        // Set the currentUser String got from Login Activity into TextView
        userName = this.getIntent().getStringExtra("currentUserName");
        txtuser.setText("You are logged in as " + this.getUserName());
        // Locate Button in welcome.xml
        logout = (Button) findViewById(R.id.logout);

        // Logout Button Click Listener
        logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticationUtils.logout();
                Toast.makeText(getApplicationContext(),
                        "Logged Out",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginSuccess.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
