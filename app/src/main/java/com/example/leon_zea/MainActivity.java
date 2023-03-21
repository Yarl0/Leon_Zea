package com.example.leon_zea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaPrincipalProducto;
    private RecyclerView recvwpro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_listadp));
        cargarDatos();

        recvwpro=findViewById(R.id.recvwpro);

        AdaptadorPersonalizado miadaptador = new AdaptadorPersonalizado(listaPrincipalProducto);

        miadaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Producto producto, int posicion) {

                Intent intent =new Intent(MainActivity.this, Detalleactivity.class);
                intent.putExtra("producto",producto);
                startActivity(intent);
            }

            @Override
            public void onItembtnEraseClick(Producto producto, int posicion) {

                listaPrincipalProducto.remove(posicion);
                miadaptador.setListinfo(listaPrincipalProducto);

            }
        });

        recvwpro.setAdapter(miadaptador);
        recvwpro.setLayoutManager(new LinearLayoutManager(this));
    }
    public  void cargarDatos(){
        Producto producto1= new Producto();
        producto1.setNombre("PC Hp");
        producto1.setPrecio(800000.0);
        producto1.setUrl_img("https://w7.pngwing.com/pngs/164/206/png-transparent-black-hp-computer-set-hewlett-packard-laptop-hp-pavilion-desktop-computer-dell-computer-desktop-pc-electronics-computer-computer-monitor-accessory.png");

        Producto producto2 = new Producto();
        producto2.setNombre("teclado");
        producto2.setPrecio(50000.0);
        producto2.setUrl_img("https://tauretcomputadores.com/images/products/Product_202204251623411080508427.png");

        Producto producto3 = new Producto();
        producto3.setNombre("Mouse");
        producto3.setPrecio(10000.0);
        producto3.setUrl_img("https://png.pngtree.com/png-vector/20220703/ourmid/pngtree-illustration-of-gaming-mouse-png-image_5563085.png");

        listaPrincipalProducto =new ArrayList<>();
        listaPrincipalProducto.add(producto1);
        listaPrincipalProducto.add(producto2);
        listaPrincipalProducto.add(producto3);
    }




}