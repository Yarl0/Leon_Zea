package com.example.leon_zea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaPrincipalProducto;
    private RecyclerView recvwpro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();

        recvwpro=findViewById(R.id.recvwpro);

        AdaptadorPersonalizado miadaptador = new AdaptadorPersonalizado(listaPrincipalProducto);

        recvwpro.setAdapter(miadaptador);
        recvwpro.setLayoutManager(new LinearLayoutManager(this));
    }
    public  void cargarDatos(){
        Producto producto1= new Producto();
        producto1.setNombre("PC Hp");
        producto1.setPrecio(800000.0);
        producto1.setUrl_img("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngwing.com%2Fes%2Ffree-png-xwjkk&psig=AOvVaw2ggnGtME6Rz7sOmBQoaXlC&ust=1678917060199000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCIjmy8uz3P0CFQAAAAAdAAAAABAm");

        Producto producto2 = new Producto();
        producto2.setNombre("teclado");
        producto2.setPrecio(50000.0);
        producto2.setUrl_img("https://www.google.com/url?sa=i&url=https%3A%2F%2Fpngimg.com%2Fimage%2F5869&psig=AOvVaw1UyhZcGbTi5_Enu5COipbP&ust=1678917297888000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCPD3xbu03P0CFQAAAAAdAAAAABAD");

        Producto producto3 = new Producto();
        producto3.setNombre("Mouse");
        producto3.setPrecio(10000.0);
        producto3.setUrl_img("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngall.com%2Fes%2Fpc-mouse-png&psig=AOvVaw02hl23W_RtATuuVNVKwQ7s&ust=1678917266238000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCKjkray03P0CFQAAAAAdAAAAABAH");

        listaPrincipalProducto =new ArrayList<>();
        listaPrincipalProducto.add(producto1);
        listaPrincipalProducto.add(producto2);
        listaPrincipalProducto.add(producto3);
    }




}