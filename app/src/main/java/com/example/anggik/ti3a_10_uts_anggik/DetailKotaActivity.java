package com.example.anggik.ti3a_10_uts_anggik;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DetailKotaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterRecyclerView adapterRecyclerView;
    Button btnBackInput;

    Cursor cursor;
    DataKotaHelper dataKotaHelper;

    ArrayList<String> dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kota);

        recyclerView = findViewById(R.id.rv);
        btnBackInput = findViewById(R.id.btnBackInput);
        dataKotaHelper = new DataKotaHelper(this);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        btnBackInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailKotaActivity.this, InputDataActivity.class);
                startActivity(intent);
            }
        });
        refreshList();
    }

    private void refreshList() {
        SQLiteDatabase db = dataKotaHelper.getReadableDatabase();
        dataset = new ArrayList<String>();

        cursor = db.rawQuery("Select * from kota",null);
        cursor.moveToFirst();
        for (int cc=0; cc<cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            dataset.add(cursor.getString(0).toString());
        }

        adapterRecyclerView = new AdapterRecyclerView(dataset);

        recyclerView.setAdapter(adapterRecyclerView);
    }
}
