package com.example.yazlabproje3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GirisActivity extends AppCompatActivity {

    EditText kullaniciadi, parola;
    Button giris;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        Toast.makeText(GirisActivity.this, "Giriş Yapınız..", Toast.LENGTH_LONG).show();

        kullaniciadi = (EditText) findViewById(R.id.kullaniciadi);
        parola = (EditText) findViewById(R.id.parola);
        giris = (Button) findViewById(R.id.giris);


        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GirisActivity.this, "Giriş Başarılı", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("kadi", kullaniciadi.getText().toString());
                startActivity(intent);
            }
        });
    }
}
