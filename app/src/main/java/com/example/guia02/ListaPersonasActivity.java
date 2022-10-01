package com.example.guia02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.guia02.MainActivity.lstPersona;

public class ListaPersonasActivity extends AppCompatActivity {

    private ListView lstVistaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lstVistaPersonas = findViewById(R.id.lsvPersonas);

//        lstPersona.add(new Persona(1,"Juan", "Perez"));

        lstVistaPersonas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lstPersona));

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}