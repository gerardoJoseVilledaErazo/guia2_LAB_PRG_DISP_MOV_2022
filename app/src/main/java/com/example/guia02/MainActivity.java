package com.example.guia02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guia02.Model.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAgregarPersona, btnMostrarListaPersona, btnDatos;

    public static List<Persona> lstPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPersona = new ArrayList<>();

        btnAgregarPersona = findViewById(R.id.btnAgregarPersona);
        btnAgregarPersona.setOnClickListener(this);

        btnMostrarListaPersona = findViewById(R.id.btnMostrarListaPersona);
        btnMostrarListaPersona.setOnClickListener(this);

        btnDatos = findViewById(R.id.btnDatos);
        btnDatos.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarPersona:
                startActivity(new Intent(this, AgregarPersonaActivity.class));
                break;
            case R.id.btnMostrarListaPersona: {
                if (lstPersona.isEmpty() == false) {
                    startActivity(new Intent(this, ListaPersonasActivity.class));
                } else {
                    //                    Toast.makeText(this,"Lista de personas se encuentra vacía.", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(this).setTitle("¡Aviso!")
                            .setMessage("Lista de personas se encuentra vacía.")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                }
            }break;
            case R.id.btnDatos:
                startActivity(new Intent(this, DatosActivity.class));
                break;
        }
    }
}