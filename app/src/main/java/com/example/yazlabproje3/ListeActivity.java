package com.example.yazlabproje3;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListeActivity extends AppCompatActivity {

    ListView listViewReklamlar;
    List<Reklam> reklamList;

    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        reff = FirebaseDatabase.getInstance().getReference("Reklam");
        listViewReklamlar = (ListView) findViewById(R.id.listViewReklamlar);
        reklamList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                reklamList.clear();
                for (DataSnapshot reklamSnapshot : dataSnapshot.getChildren()) {
                    Reklam reklam = reklamSnapshot.getValue(Reklam.class);
                    reklamList.add(reklam);
                }

                ListeIcerikActivity adapter = new ListeIcerikActivity(ListeActivity.this, reklamList);
                listViewReklamlar.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
