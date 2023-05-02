package com.example.leon_zea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    private TextView edit_nombre;
    private TextView edit_precio;
    private TextView edit_imagen;
    private Button actu_prod;
    private ArrayList<Producto> Listaprincipalproducto;
    private RecyclerView rv_listado_productos;

    public EditActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        actu_prod = findViewById(R.id.actu_prod);
        actu_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Producto productonuevo = new Producto();
                productonuevo.setNombre(edit_nombre.getText().toString());
                productonuevo.setPrecio(Double.parseDouble(edit_precio.getText().toString()));
                productonuevo.setUrl_img(edit_nombre.getText().toString());

                Listaprincipalproducto = new ArrayList<>();
                Listaprincipalproducto.add(productonuevo);

                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                firestore.collection("Porductos").add(productonuevo);

                Toast.makeText(EditActivity.this, "Se actualizo el producto", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}