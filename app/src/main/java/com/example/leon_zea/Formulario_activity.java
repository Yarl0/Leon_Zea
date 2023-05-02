package com.example.leon_zea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.leon_zea.Producto;
import com.example.leon_zea.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Formulario_activity extends AppCompatActivity {

    private TextView prod_nombre;
    private TextView prod_precio;
    private TextView prod_imagen;
    private Button crear_prod;
    private ArrayList<Producto> Listaprincipalproducto;
    private RecyclerView rv_listado_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        crear_prod = findViewById(R.id.crear_prod);
        crear_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Producto productonuevo = new Producto();
                productonuevo.setNombre(prod_nombre.getText().toString());
                productonuevo.setPrecio(Double.parseDouble(prod_precio.getText().toString()));
                productonuevo.setUrl_img(prod_imagen.getText().toString());

                Listaprincipalproducto = new ArrayList<>();
                Listaprincipalproducto.add(productonuevo);

                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                firestore.collection("Porductos").add(productonuevo);

                Toast.makeText(Formulario_activity.this, "Se creo el producto", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}