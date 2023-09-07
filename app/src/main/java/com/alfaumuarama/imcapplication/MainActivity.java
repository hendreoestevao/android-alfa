package com.alfaumuarama.imcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nome,altura,peso,ra;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome =  findViewById(R.id.editTextNome);
        altura =  findViewById(R.id.editTextAltura);
        peso =  findViewById(R.id.editTextPeso);
        ra = findViewById(R.id.editTextRa);
        botao =  findViewById(R.id.buttonOK);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarTelaResultado();
            }
        });
     }

     public void mostrarTelaResultado(){

        if(TextUtils.isEmpty(nome.getText().toString())){
            nome.setError("campo Obrigatório");
            return;
        }
         if(TextUtils.isEmpty(altura.getText().toString())){
             altura.setError("campo Obrigatório");
             return;
         }
         if(TextUtils.isEmpty(peso.getText().toString())){
             peso.setError("campo Obrigatório");
             return;
         }
         if(TextUtils.isEmpty(ra.getText().toString())){
             peso.setError("campo Obrigatório");
             return;
         }
         Intent intent = new Intent(this, ResultActivity.class);
         intent.putExtra("nome", nome.getText().toString());
         intent.putExtra("altura",altura.getText().toString());
         intent.putExtra("peso", peso.getText().toString());
         intent.putExtra("ra", ra.getText().toString());
         startActivity(intent);
     }
}