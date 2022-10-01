package com.example.guia02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.guia02.MainActivity.lstPersona;

import com.example.guia02.Model.Persona;
import com.example.guia02.Utils.Utils;

public class AgregarPersonaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtID, edtNombre, edtApellido;
    private Button btnAgregar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ******************* Instancias a los componentes graficos *********************
        edtID = (EditText) findViewById(R.id.edtID);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido = (EditText) findViewById(R.id.edtApellido);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregar: {
                if (Utils.verifyEmpty(edtID) &&
                    Utils.verifyTextPersonName(edtNombre) &&
                    Utils.verifyTextPersonName(edtApellido)
                ){

                    new AlertDialog.Builder(this)
                            .setTitle("¡Confirmacion!")
                            .setMessage("Registro exitoso")
                            .setPositiveButton("O.K.", (dialogInterface, i) -> {

                                agregar(Integer.parseInt(edtID.getText().toString()),
                                        edtNombre.getText().toString(),
                                        edtApellido.getText().toString());

                                finish();
                            })
                            .setNegativeButton("Cancelar",null )
                            .show();
                }
            }break;
            case R.id.btnCancelar: {
                edtID.setText("");
                edtNombre.setText("");
                edtApellido.setText("");
            }break;
        }
    }

    private void agregar(int idPersona,
                         String nombre,
                         String apellido) {

//        Persona persona = new Persona(idPersona, nombre, apellido);
//        lstPersona.add(persona);
        lstPersona.add(new Persona(idPersona, nombre, apellido));
    }
}