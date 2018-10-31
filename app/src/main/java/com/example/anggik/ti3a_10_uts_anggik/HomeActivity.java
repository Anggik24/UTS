package com.example.anggik.ti3a_10_uts_anggik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    TextView txtUser;
    Button btnGoInput;
    Session session;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtUser = findViewById(R.id.txtUser);
        btnGoInput = findViewById(R.id.btnInput);

        session = new Session(this);
        loginUser = session.getUserInformation();

        Toast.makeText(this, session.isLoggedIn()+"",Toast.LENGTH_LONG).show();

        txtUser.setText(loginUser.get(session.KEY_EMAIL));

        btnGoInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,InputDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
