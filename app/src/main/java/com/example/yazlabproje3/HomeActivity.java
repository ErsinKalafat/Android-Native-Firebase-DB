package com.example.yazlabproje3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView oturumIsmi;
    Button btnYeniReklam, btnReklamListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        oturumIsmi = (TextView) findViewById(R.id.oturumIsmi);
        btnYeniReklam = (Button) findViewById(R.id.btnYeniReklam);
        btnReklamListesi = (Button) findViewById(R.id.btnReklamListesi);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            oturumIsmi.setText(extras.getString("kadi"));            // intentten gelen veriyi textview'a basıyoruz.
        }

        btnReklamListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListeActivity.class);
                startActivity(intent);
            }
        });

        btnYeniReklam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReklamEkleActivity.class);
                startActivity(intent);
            }
        });


    }
}
