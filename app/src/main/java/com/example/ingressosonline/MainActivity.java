package com.example.ingressosonline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(MainActivity.this,Menu_opcoes.class);
                startActivity(welcome);

                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },WELCOME_TIMEOUT);



    }
}
