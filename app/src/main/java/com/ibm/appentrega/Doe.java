package com.ibm.appentrega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Doe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doe);

        TextView text_boasvindas = findViewById(R.id.boasvindas);
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");
        text_boasvindas.setText("Bem vindo(a), " + nome.toString() + "!");
    }
}