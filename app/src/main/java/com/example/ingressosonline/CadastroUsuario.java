package com.example.ingressosonline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class CadastroUsuario extends AppCompatActivity {

    Button ConfirmarCadastro;

    /* Declaração para cadastro no database */
    DatabaseReference databaseReference;

    /*Campos do cadastro do usuario*/
    TextView CPF_usuario;
    TextView Senha_usuario;
    TextView Nome_usuario;
    TextView NumeroCartao_usuario;
    TextView CodigoSegurança_usuario;
    TextView Validade_usuario;

    /*Converte variáveis para o tipo string*/


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);


        /* Funcoes para cadastrar no banco */
        databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");

        CPF_usuario = findViewById(R.id.CPF_cadastro);
        Senha_usuario = findViewById(R.id.senha_id);
        Nome_usuario = findViewById(R.id.nome_id);
        NumeroCartao_usuario = findViewById(R.id.numCartao_id);
        CodigoSegurança_usuario = findViewById(R.id.codSeguranca_id);
        Validade_usuario = findViewById(R.id.data_validade);


        ConfirmarCadastro = findViewById(R.id.btn_confirma);
        ConfirmarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsuario();

                Toast.makeText(CadastroUsuario.this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastroUsuario.this,Login.class);
                startActivity(intent);
            }
        });

    }
    protected void addUsuario(){
        String Nome = Nome_usuario.getText().toString();
        String CPF = CPF_usuario.getText().toString();
        String Senha = Senha_usuario.getText().toString();
        String NumeroCartao = NumeroCartao_usuario.getText().toString();
        String CodigoSegurana = CodigoSegurança_usuario.getText().toString();
        String ValidadeCartao =Validade_usuario.getText().toString();


        if (!TextUtils.isEmpty(CPF)){
            String id = databaseReference.push().getKey();
            String id_usuario = FirebaseAuth.getInstance().getUid();

            Usuario usuarios = new Usuario(id,Nome, CPF, Senha, NumeroCartao,CodigoSegurana,ValidadeCartao,id_usuario);
            databaseReference.child(id).setValue(usuarios);

            /*Zerar os dados*/
            Nome_usuario.setText("");
            CPF_usuario.setText("");
            Senha_usuario.setText("");
            NumeroCartao_usuario.setText("");
            CodigoSegurança_usuario.setText("");
            Validade_usuario.setText("");


        }else{
            Toast.makeText(CadastroUsuario.this, "Preencha os dados corretamente.", Toast.LENGTH_LONG).show();
        }

    }
}
