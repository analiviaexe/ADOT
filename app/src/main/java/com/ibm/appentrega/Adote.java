package com.ibm.appentrega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Adote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adote);

        EditText email = findViewById(R.id.form_email);
        EditText cidade = findViewById(R.id.form_cidade);

        cidade.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    String nome = cidade.getText().toString();
                    if(cidade.length() == 0 || email.length() == 0){
                        Toast.makeText(getApplicationContext(), "Por favor, preencha ambos os campos!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Inscrição enviada!", Toast.LENGTH_LONG).show();
                    }
                }

                return false;
            }
        });
    }
}