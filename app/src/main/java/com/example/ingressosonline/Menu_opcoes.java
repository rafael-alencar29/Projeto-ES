package com.example.ingressosonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Menu_opcoes extends AppCompatActivity {
    DatabaseReference databaseReference;
    DatabaseReference reference;
    private StorageReference mStorageRef;

    private FirebaseAuth mAuth;

    Button comprar;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        reference = FirebaseDatabase.getInstance().getReference().child("usuarios");

        comprar = findViewById(R.id.comprar);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_opcoes.this, Menu_ingressos.class);
                startActivity(intent);
            }
        });

        cadastrar = findViewById(R.id.cadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_opcoes.this,Login.class );
                startActivity(intent);
            }
        });


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void updateUI(FirebaseUser user){

        if(user == null){
            mAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    }else{
                        updateUI(null);
                    }
                }
            });
        }
    }
}
