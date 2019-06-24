package com.example.yazlabproje3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListeIcerikActivity extends ArrayAdapter<Reklam> {

    Activity context;
    List<Reklam> reklamList;

    public ListeIcerikActivity(Activity context, List<Reklam> reklamList) {
        super(context, R.layout.activity_liste,reklamList);
        this.context = context;
        this.reklamList = reklamList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_liste_icerik,null,true);

        TextView tvFirmaID = (TextView) listViewItem.findViewById(R.id.tvFirmaID);
        TextView tvFirmaAdi = (TextView) listViewItem.findViewById(R.id.tvFirmaAdi);
        TextView tvFirmaLokasyonu = (TextView) listViewItem.findViewById(R.id.tvFirmaLokasyonu);
        TextView tvKampanyaIcerik = (TextView) listViewItem.findViewById(R.id.tvKampanyaIcerik);
        TextView tvKampanyaSuresi = (TextView) listViewItem.findViewById(R.id.tvKampanyaSuresi);

        Reklam reklam = reklamList.get(position);

        tvFirmaID.setText(reklam.getFirmaID());
        tvFirmaAdi.setText(reklam.getFirmaAdi());
        tvFirmaLokasyonu.setText(reklam.getFirmaLokasyon());
        tvKampanyaIcerik.setText(reklam.getKampanyaIcerik());
        tvKampanyaSuresi.setText(reklam.getKampanyaSuresi());

        return listViewItem;
    }
}







//    DatabaseReference reff;
//    ListView listView;
//
//    ArrayList<String> arrayList = new ArrayList<>();
//    ArrayAdapter<String> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_liste);
//
//        listView = (ListView) findViewById(R.id.listView);
//        oturumIsmi = (TextView) findViewById(R.id.oturumIsmi);                  // intentten gelen veriyi textview'a basıyoruz.
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            oturumIsmi.setText(extras.getString("kadi"));                  // --------------------------------------------
//        }





//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
//        listView.setAdapter(adapter);
//
//        reff.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                String string = dataSnapshot.getValue(String.class);
//                arrayList.add(string);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });




//        reff= FirebaseDatabase.getInstance().getReference().child("reklam").child("1");
//        reff.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });




