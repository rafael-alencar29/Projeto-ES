package com.example.ingressosonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CadastrarEvento extends AppCompatActivity {
    public List<String> chaves = new ArrayList<String>();
    List<String> D = new ArrayList<String>();

    ArrayList<Usuario> user;

    List<String> CPF_users = new ArrayList<String>();

    Button confimarEvento;
    TextView codigo_id;
    TextView nome_evento;
    TextView cod_apre;
    TextView cod_data;
    TextView cod_Hora;
    TextView cod_preco;
    TextView cod_sala;
    TextView cod_cidade;
    TextView cod_Estado;
    TextView cod_classe;
    TextView cod_faixaEtaria;

    /* Declaração para cadastro no database */
    DatabaseReference databaseReference1, IdUsuario, referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_evento);

        /* Funcoes para cadastrar no banco */
        databaseReference1 = FirebaseDatabase.getInstance().getReference("eventos");
        IdUsuario = FirebaseDatabase.getInstance().getReference("usuarios");
        referencia = FirebaseDatabase.getInstance().getReference("usuarios");

        codigo_id = findViewById(R.id.codigo_id);
        nome_evento = findViewById(R.id.nome_evento);
        cod_apre = findViewById(R.id.cod_apre);
        cod_data = findViewById(R.id.cod_data);
        cod_Hora = findViewById(R.id.cod_Hora);
        cod_preco = findViewById(R.id.cod_preco);
        cod_sala = findViewById(R.id.cod_sala);
        cod_cidade = findViewById(R.id.cod_cidade);
        cod_Estado = findViewById(R.id.cod_Estado);
        cod_classe = findViewById(R.id.cod_classe);
        cod_faixaEtaria = findViewById(R.id.cod_faixaEtaria);
        confimarEvento = findViewById(R.id.btn_confirmaEvento);

        confimarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvento();

                Toast.makeText(CadastrarEvento.this, "Evento criado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastrarEvento.this,Menu_opcoes.class);
                startActivity(intent);
            }
        });
    }

   /*
    public void addEvento(){
        String codigo = codigo_id.getText().toString();
        String nomeEvento = nome_evento.getText().toString();
        String apresentacao = cod_apre.getText().toString();
        String data = cod_data.getText().toString();
        String hora = cod_Hora.getText().toString();
        String preco = cod_preco.getText().toString();
        String sala = cod_sala.getText().toString();
        String cidade = cod_cidade.getText().toString();
        String estado = cod_Estado.getText().toString();
        String classe = cod_classe.getText().toString();
        String faixaEtaria = cod_faixaEtaria.getText().toString();


        if (!TextUtils.isEmpty(codigo)){
            String id = databaseReference1.push().getKey();
            //String id_usuario = IdUsuario.push().getKey();
            //String id_usuario = FirebaseAuth.getInstance().getUid();




            String  id_usuario = IdUsuario.child(id).getKey();


            //Idusers();

            RetornaId();
            Toast.makeText(CadastrarEvento.this, ""+ D.size(), Toast.LENGTH_LONG).show();

            Evento evento = new Evento(id,id_usuario,nomeEvento,codigo,apresentacao,data,hora,preco,sala,cidade,estado,classe,faixaEtaria);
            databaseReference1.child(id).setValue(evento);

            codigo_id.setText("");
            nome_evento.setText("");
            cod_apre.setText("");
            cod_data.setText("");
            cod_Hora.setText("");
            cod_preco.setText("");
            cod_sala.setText("");
            cod_cidade.setText("");
            cod_Estado.setText("");
            cod_classe.setText("");
            cod_faixaEtaria.setText("");

        }else{
            Toast.makeText(CadastrarEvento.this, "Preencha os dados corretamente.", Toast.LENGTH_LONG).show();
        }
    }
    */
    public void addEvento(){


        referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    String key = dataSnapshot1.getKey();
                    chaves.add(key);

                    Usuario user = dataSnapshot1.getValue(Usuario.class);

                    CPF_users.add(user.getCPF());

                }
                //Toast.makeText(CadastrarEvento.this, ""+ chaves.size(), Toast.LENGTH_LONG).show();

                //Toast.makeText(CadastrarEvento.this, ""+ chaves.get(0), Toast.LENGTH_LONG).show();
                //Toast.makeText(CadastrarEvento.this, ""+ chaves.get(1), Toast.LENGTH_LONG).show();

                String codigo = codigo_id.getText().toString();
                String nomeEvento = nome_evento.getText().toString();
                String apresentacao = cod_apre.getText().toString();
                String data = cod_data.getText().toString();
                String hora = cod_Hora.getText().toString();
                String preco = cod_preco.getText().toString();
                String sala = cod_sala.getText().toString();
                String cidade = cod_cidade.getText().toString();
                String estado = cod_Estado.getText().toString();
                String classe = cod_classe.getText().toString();
                String faixaEtaria = cod_faixaEtaria.getText().toString();



                if (!TextUtils.isEmpty(codigo)){
                    String id = databaseReference1.push().getKey();
                    String id_usua = IdUsuario.push().getKey();
                    //String id_usuario = FirebaseAuth.getInstance().getUid();

                    String  id_usuario = "";
                    //Toast.makeText(CadastrarEvento.this, ""+ CPF_users.get(0), Toast.LENGTH_LONG).show();


                    Login login = new Login();





                   // Toast.makeText(CadastrarEvento.this, "", Toast.LENGTH_LONG).show();


                    Evento evento = new Evento(id,id_usuario,nomeEvento,codigo,apresentacao,data,hora,preco,sala,cidade,estado,classe,faixaEtaria);
                    databaseReference1.child(id).setValue(evento);

                    codigo_id.setText("");
                    nome_evento.setText("");
                    cod_apre.setText("");
                    cod_data.setText("");
                    cod_Hora.setText("");
                    cod_preco.setText("");
                    cod_sala.setText("");
                    cod_cidade.setText("");
                    cod_Estado.setText("");
                    cod_classe.setText("");
                    cod_faixaEtaria.setText("");

                }else{
                    Toast.makeText(CadastrarEvento.this, "Preencha os dados corretamente.", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
