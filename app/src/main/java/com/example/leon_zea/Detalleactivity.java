package com.example.leon_zea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detalleactivity extends AppCompatActivity {
    private TextView tvdetnm, tvdeprecio;
    private ImageView ivdet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalleactivity);
        setTitle(getString(R.string.txt_detalles));

        tvdetnm=findViewById(R.id.tvdetnm);
        tvdeprecio=findViewById(R.id.tvdeprecio);
        ivdet=findViewById(R.id.ivdet);


        Producto productocatch =(Producto) getIntent().getSerializableExtra("producto");

        tvdetnm.setText(productocatch.getNombre());
        tvdeprecio.setText(productocatch.getNombre());
        Picasso.get()
                .load(productocatch.getUrl_img())
                .error(R.drawable.ic_launcher_background)
                .into(ivdet);


    }
}