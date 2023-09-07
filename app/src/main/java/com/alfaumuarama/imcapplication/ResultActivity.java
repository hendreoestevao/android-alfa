package com.alfaumuarama.imcapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultado;
    String strNome;
    Float fltAltura, fltPeso, fltResult,fltRa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultado = (TextView) findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        strNome = intent.getStringExtra("nome");
        fltAltura = Float.parseFloat(intent.getStringExtra("altura"));
        fltPeso = Float.parseFloat(intent.getStringExtra("peso"));
        fltRa = Float.parseFloat(intent.getStringExtra("ra"));
        fltResult = fltPeso / (fltAltura * fltAltura);

        String strResult = "Olá " + strNome + " R.A: " + fltRa + "!";
        strResult = strResult + "\n" + "IMC = " + fltResult.toString();

        if(fltResult < 18.5) {
            strResult = strResult + "\n" + "Magreza";
        }
        else if(fltResult > 18.6 && fltResult < 24.9){
            strResult = strResult + "\n" + "Normal";
        }
        else if(fltResult > 25 && fltResult < 29.9){
            strResult = strResult + "\n" + "Sobrepeso";
        }
        else if(fltResult > 30 && fltResult < 39.9){
            strResult = strResult + "\n" + "Obesidade";
        }
        else {
            strResult = strResult + "\n" + "Obesidade Grave";
        }
        new AlertDialog.Builder(resultado.getContext())
                .setTitle("Resultado")
                .setMessage(strResult.toString())
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
        resultado.setText(strResult);
    }
}