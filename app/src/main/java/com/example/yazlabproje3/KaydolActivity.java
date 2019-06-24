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

public class KaydolActivity extends AppCompatActivity {

    EditText kullaniciadi, parola;
    Button kaydol;
    DatabaseReference reff;
    Uye uye;
    long uyeNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);
        Toast.makeText(KaydolActivity.this, "Giriş yapabilmek için kayıt olunuz..", Toast.LENGTH_LONG).show();

        kullaniciadi = (EditText) findViewById(R.id.kullaniciadi);
        parola = (EditText) findViewById(R.id.parola);
        kaydol = (Button) findViewById(R.id.kaydol);

        uye = new Uye();

        reff = FirebaseDatabase.getInstance().getReference().child("Uye");      // Buluta bağlanıp "Uye" isminde tabloyu açıyoruz.

        reff.addValueEventListener(new ValueEventListener() {                   // Kayıt no otomatik artması için veri sayısını alıyor.
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    uyeNo = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });                                                                     //-----------------------------------------------------


        kaydol.setOnClickListener(new View.OnClickListener() {                   // Butona tıklandığında verileri buluta ekliyor.
            @Override
            public void onClick(View v) {
                uye.setKullaniciadi(kullaniciadi.getText().toString().trim());
                uye.setParola(parola.getText().toString().trim());

                reff.child("Kayıt : " + String.valueOf(uyeNo + 1)).setValue(uye);
                Toast.makeText(KaydolActivity.this, "Kullanıcı Kaydı Başarılı :)", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });                                                                     //----------------------------------------------
    }
}
