package com.example.ingressosonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Eventos extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Evento> lista;

    MyAdapter adapter;
    private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        //Intent intent = getIntent();
        //String[] DadosObtidos = intent.getStringArrayExtra("Dados");
        //Toast.makeText(Eventos.this, ""+DadosObtidos[0], Toast.LENGTH_LONG).show();
        //Toast.makeText(Eventos.this, ""+DadosObtidos[1], Toast.LENGTH_LONG).show();
        //Toast.makeText(Eventos.this, ""+DadosObtidos[2], Toast.LENGTH_LONG).show();

        mStorageRef = FirebaseStorage.getInstance().getReference();

        recyclerView = (RecyclerView) findViewById(R.id.recycle); // ou card_view2
        recyclerView.setLayoutManager(new LinearLayoutManager(this) );

        lista = new ArrayList<Evento>();

        reference = FirebaseDatabase.getInstance().getReference().child("eventos");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Intent intent = getIntent();
                String[] DadosObtidos = intent.getStringArrayExtra("Dados");

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    Evento evento = dataSnapshot1.getValue(Evento.class);
                    if( DadosObtidos[0].equals(evento.getData()) || DadosObtidos[1].equals(evento.getCidade())
                            || DadosObtidos[2].equals(evento.getEstado()) ){
                        lista.add(evento);
                    }

                }
                adapter = new MyAdapter(Eventos.this,lista);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
