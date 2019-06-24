package com.example.yazlabproje3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnSayfaKaydol, btnSayfaGirisyap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Hoşgeldiniz! Firebase bağlantısı başarılı", Toast.LENGTH_LONG).show();

        btnSayfaKaydol = (Button) findViewById(R.id.btnSayfaKaydol);
        btnSayfaGirisyap = (Button) findViewById(R.id.btnSayfaGirisyap);

        btnSayfaKaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KaydolActivity.class);
                startActivity(intent);
            }
        });

        btnSayfaGirisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GirisActivity.class);
                startActivity(intent);
            }
        });
    }
}
