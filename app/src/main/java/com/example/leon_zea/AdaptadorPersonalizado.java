package com.example.leon_zea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder>{

    private ArrayList<Producto> listinfo;

    public AdaptadorPersonalizado(ArrayList<Producto> listinfo) {
        this.listinfo = listinfo;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View miview= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_productos,parent,false);

        return new ViewHolder(miview);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {
        Producto miproducto = listinfo.get(position);
        holder.enlazar(miproducto);


    }

    @Override
    public int getItemCount() {
        return listinfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombre, TvPrecio;
        private ImageView IvProducto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre= itemView.findViewById(R.id.tv_itm_nombre);
            TvPrecio= itemView.findViewById(R.id.itm_precio);
            IvProducto= itemView.findViewById(R.id.itm_img);
        }

        public void enlazar(Producto miproducto){
            tvNombre.setText(miproducto.getNombre());
            TvPrecio.setText(miproducto.getPrecio().toString());

        }
    }
}
