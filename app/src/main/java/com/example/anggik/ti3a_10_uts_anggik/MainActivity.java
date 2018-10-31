package com.example.anggik.ti3a_10_uts_anggik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button btnLogin;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        session = new Session(this);
        if (session.isLoggedIn()){
            goToActivity();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                if(username.matches("")|| username.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Username dan Password tidak boleh kosong",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    session.createLoginSession(username,password);
                    goToActivity();
                }
            }
        });

    }

    private void goToActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
