package com.example.ingressosonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference;
    DatabaseReference reference;
    private StorageReference mStorageRef;

    public ArrayList<String> keys;

    ArrayList<Usuario> users;

    private FirebaseAuth mAuth;
    TextView  cadastro;
    Button entrar;

    EditText CPF_user;
    EditText Senha_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mStorageRef = FirebaseStorage.getInstance().getReference();
        reference = FirebaseDatabase.getInstance().getReference().child("usuarios");

        users = new ArrayList<Usuario>();
        keys = new ArrayList<String>();

        /*Tentativa de login do usuario*/
        CPF_user = (EditText) findViewById(R.id.CPF);
        Senha_user = (EditText) findViewById(R.id.senha);

        entrar = findViewById(R.id.entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    reference.addValueEventListener(new ValueEventListener() {
                         String CPF = CPF_user.getText().toString();
                         String Senha = Senha_user.getText().toString();

                        String usario_key = ""; //nova variavel



                        //String idd = databaseReference.push().getKey();
                        //String id_usuario = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        //FirebaseUser userr = FirebaseAuth.getInstance().getCurrentUser();
                        String CPF__firebase;
                        String Senha_firebase;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            int i = 0;

                            for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                                String key=dataSnapshot1.getKey();
                                keys.add(key); //Armazena o id do usuario

                                Usuario user = dataSnapshot1.getValue(Usuario.class);
                                users.add(user);

                                String aux = users.get(i).getCPF();
                                String aux2 = users.get(i).getSenha();

                                if( CPF.trim().equals(aux)   && Senha.trim().equals(aux2) ){
                                     CPF__firebase  = aux;
                                     Senha_firebase = aux2;

                                }
                                i++;
                            }
                            if(CPF.isEmpty() || Senha.isEmpty()){
                                Toast.makeText(Login.this, "Preencha todo os campos", Toast.LENGTH_LONG).show();
                            }else if(CPF.trim().equals(CPF__firebase) && (Senha.trim().equals(Senha_firebase))){
                                    CPF = CPF__firebase;
                                    Senha = Senha_firebase;

                                    Intent intent = new Intent(Login.this,CadastrarEvento.class);
                                    intent.putExtra("CPF",CPF);
                                    startActivity(intent);
                            }else{
                                Toast.makeText(Login.this, "CPF ou senha incorretos", Toast.LENGTH_LONG).show();
                            }
                        }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                    });

            }
        });

        //O botao castrado dá acesso ao cadastro do usuario caso este nao tenha uma conta
        cadastro = findViewById(R.id.cadastro);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this,CadastroUsuario.class);
                startActivity(intent);

            }
        });
    }
}
