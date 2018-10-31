package com.example.anggik.ti3a_10_uts_anggik;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputDataActivity extends AppCompatActivity {

    DataKotaHelper dataKotaHelper;
    EditText txtInput;
    Button btnSimpan, btnCek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        txtInput = findViewById(R.id.inputKota);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnCek = findViewById(R.id.btnCek);
        dataKotaHelper = new DataKotaHelper(this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = txtInput.getText().toString();
                SQLiteDatabase db = dataKotaHelper.getWritableDatabase();
                db.execSQL("insert into kota (nama) values ('"+nama+"')");
                Toast.makeText(InputDataActivity.this, "Input Berhasil",Toast.LENGTH_LONG).show();

            }
        });
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputDataActivity.this, DetailKotaActivity.class);
                startActivity(intent);
            }
        });
    }
}
