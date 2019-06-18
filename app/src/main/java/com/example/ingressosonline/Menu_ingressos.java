package com.example.ingressosonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Menu_ingressos extends AppCompatActivity {

    TextView user_data;
    TextView user_cidade;
    TextView user_estado;

    ArrayList<Evento> event;
    Button buscar;
    DatabaseReference databaseReference;
    DatabaseReference reference;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /*Variaveis que o usuario informara para fazer a consulta */
        user_data = (TextView) findViewById(R.id.user_data);
        user_cidade = (TextView) findViewById(R.id.user_cidade);
        user_estado = (TextView) findViewById(R.id.user_estado);

        /*Referecias para a consulta no banco de dados */
        mStorageRef = FirebaseStorage.getInstance().getReference();
        reference = FirebaseDatabase.getInstance().getReference().child("eventos");


        buscar = (Button) findViewById(R.id.btn_buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference.addValueEventListener(new ValueEventListener() {
                    String Data = user_data.getText().toString();
                    String Cidade = user_cidade.getText().toString();
                    String Estado = user_estado.getText().toString();

                    String Data_firebase;
                    String Cidade_firebase;
                    String Estado_firebase;

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int i = 0;
                        for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                            Evento event = dataSnapshot1.getValue(Evento.class);

                            /*Confere os dados que o usuario digitou com os do banco de dados*/
                            if( Data.trim().equals(event.getData()) ) {
                                Data_firebase = event.getData();
                            }
                            if( Cidade.trim().equals(event.getCidade()) ){
                                Cidade_firebase = event.getCidade();
                            }
                            if( Estado.trim().equals(event.getEstado()) ) {
                                Estado_firebase = event.getEstado();
                            }
                        }

                        /*Verifica se o usuario deixou algum campo em branco*/
                        if(Data.isEmpty() || Cidade.isEmpty() || Estado.isEmpty()){
                            Toast.makeText(Menu_ingressos.this, "Preencha todo os campos corretamente", Toast.LENGTH_LONG).show();

                        }else if (Data.equals(Data_firebase) && Cidade.equals(Cidade_firebase) && Estado.equals(Estado_firebase) ){
                            String[] Dados;
                            Dados = new String[3];
                            Dados[0] =Data;
                            Dados[1] = Cidade;
                            Dados[2] = Estado;
                            Intent intent = new Intent(Menu_ingressos.this, Eventos.class);
                            intent.putExtra("Dados",Dados);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Menu_ingressos.this, "Dados não encontrados no banco", Toast.LENGTH_LONG).show();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
