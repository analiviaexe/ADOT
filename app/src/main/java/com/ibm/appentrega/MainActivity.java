package com.ibm.appentrega;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usarSpan();

        EditText campo_nome = findViewById(R.id.editTextTextPersonName);
        Button but_home = findViewById(R.id.bt_home);
        but_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                but_home.setVisibility(View.INVISIBLE);
                campo_nome.setVisibility(View.VISIBLE);
            }
        });

        Bundle bundle = new Bundle();

        campo_nome.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    String nome = campo_nome.getText().toString();
                    if(nome.length() != 0){
                        bundle.putString("nome", nome);
                        Intent in = new Intent(MainActivity.this, Doe.class);
                        in.putExtras(bundle);
                        startActivity(in);
                    } else {
                        Toast.makeText(getApplicationContext(), "Por favor, insira seu nome!", Toast.LENGTH_LONG).show();
                    }
                }

                return false;
            }
        });


    }

    public void usarSpan(){
        SpannableString spannable = new SpannableString(getString(R.string.intro));
        spannable.setSpan(
                new ForegroundColorSpan(getResources().getColor(R.color.principal)),
                3, 7,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        spannable.setSpan(
                new StyleSpan(Typeface.BOLD),
                3, 7,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        TextView textview = findViewById(R.id.textView2);
        textview.setText(spannable);
    }
}
