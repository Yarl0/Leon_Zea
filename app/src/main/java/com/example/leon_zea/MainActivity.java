package com.example.leon_zea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.leon_zea.Formulario_activity;
import com.example.leon_zea.Login_Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> Listaprincipalproducto;
    private RecyclerView rv_listado_productos;

    private AdaptadorPersonalizado miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_listado));
        cargarDatos();

        rv_listado_productos = findViewById(R.id.rv_listado_productos);

        miAdaptador = new AdaptadorPersonalizado(Listaprincipalproducto);

        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Producto producto, int posicion) {
                Intent intent = new Intent(MainActivity.this, Detalleactivity.class);
                intent.putExtra("Producto", producto);
                startActivity(intent);
            }

            @Override
            public void onItembtnEraseClick(Producto producto, int posicion) {
                Listaprincipalproducto.remove(posicion);
                miAdaptador.setListinfo(Listaprincipalproducto);
            }
        });

        rv_listado_productos.setAdapter(miAdaptador);
        rv_listado_productos.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cargarDatos() {

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("Productos").get().addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Producto productoAtrapado = document.toObject(Producto.class);
                                productoAtrapado.setId(document.getId());
                                Listaprincipalproducto.add(productoAtrapado);
                            }

                            miAdaptador.setListinfo(Listaprincipalproducto);
                        } else {
                            Toast.makeText(MainActivity.this, "No se pudo conectar al servidor", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );
    }

    public void clickAtras(View view) {
        Intent miIntent2 = new Intent(this, Login_Activity.class);
        startActivity(miIntent2);
        finish();
    }

    public void clickAdd(View view) {
        Intent miIntent3 = new Intent(this, Formulario_activity.class);
        startActivity(miIntent3);
        finish();
    }
    public void ClickEdit(View view){
        Intent miIntent4=new Intent(this,EditActivity.class);
        startActivity(miIntent4);
        finish();
    }
}