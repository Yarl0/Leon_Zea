package com.example.leon_zea;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class Formulario_activity extends AppCompatActivity {

    private EditText//meta ids

    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.);
    }
    public void ClickSave(View view){
        String nombre = .geText().toString;
        Double precio = .getText().toString();
        String url = .getText().toString();

        Producto nuevoproducto = new Producto();
        nuevoproducto.setNombre(nombre);
        nuevoproducto.setPrecio(precio);
        nuevoproducto.setUrl_img(url);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    }
}
