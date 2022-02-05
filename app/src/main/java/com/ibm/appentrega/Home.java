package com.ibm.appentrega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bt_apoie = findViewById(R.id.bt_apoie_home);
        Button bt_adote = findViewById(R.id.bt_adote_home);

        bt_apoie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(Home.this, Apoie.class);
                startActivity(in);
            }
        });

        bt_adote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(Home.this, Adote.class);
                startActivity(in);
            }
        });

        TextView text_boasvindas = findViewById(R.id.boasvindas);
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");
        text_boasvindas.setText("Bem vindo(a), " + nome.toString() + "!");
    }
}