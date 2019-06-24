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

public class ReklamEkleActivity extends AppCompatActivity {

    EditText firmaAdi, firmaLokasyon, kampanyaIcerik, kampanyaSuresi;
    Button reklamEkle;

    long reklamNo = 0;

    Reklam reklam;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reklam_ekle);

        firmaAdi = (EditText) findViewById(R.id.firmaAdi);
        firmaLokasyon = (EditText) findViewById(R.id.firmaLokasyon);
        kampanyaIcerik = (EditText) findViewById(R.id.kampanyaIcerik);
        kampanyaSuresi = (EditText) findViewById(R.id.kampanyaSuresi);
        reklamEkle = (Button) findViewById(R.id.reklamEkle);

        reklam = new Reklam();

        reff = FirebaseDatabase.getInstance().getReference().child("Reklam");      // Buluta bağlanıp "Uye" isminde tabloyu açıyoruz.

        reff.addValueEventListener(new ValueEventListener() {                   // Kayıt no otomatik artması için veri sayısını alıyor.
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    reklamNo = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });                                                                     //-----------------------------------------------------


        reklamEkle.setOnClickListener(new View.OnClickListener() {                   // Butona tıklandığında verileri buluta ekliyor.
            @Override
            public void onClick(View v) {
                reklam.setFirmaID(String.valueOf(reklamNo + 1));
                reklam.setFirmaAdi(firmaAdi.getText().toString().trim());
                reklam.setFirmaLokasyon(firmaLokasyon.getText().toString().trim());
                reklam.setKampanyaIcerik(kampanyaIcerik.getText().toString().trim());
                reklam.setKampanyaSuresi(kampanyaSuresi.getText().toString().trim());

                reff.child("Kayıt : " + String.valueOf(reklamNo + 1)).setValue(reklam);
                Toast.makeText(ReklamEkleActivity.this, "Reklam Eklendi :)", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), ListeIcerikActivity.class);
                startActivity(intent);
            }
        });
    }
}
