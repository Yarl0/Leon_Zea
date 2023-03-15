package com.example.leon_zea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder>{

    public void setListinfo(ArrayList<Producto> listinfo) {
        this.listinfo = listinfo;
        notifyDataSetChanged();
    }

    private ArrayList<Producto> listinfo;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdaptadorPersonalizado(ArrayList<Producto> listinfo) {
        this.listinfo = listinfo;
        this.onItemClickListener=null;
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
        private Button btnErase;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre= itemView.findViewById(R.id.tv_itm_nombre);
            TvPrecio= itemView.findViewById(R.id.itm_precio);
            IvProducto= itemView.findViewById(R.id.itm_img);
            btnErase = itemView.findViewById(R.id.btnErase);

        }

        public void enlazar(Producto miproducto){
            tvNombre.setText(miproducto.getNombre());
            TvPrecio.setText(miproducto.getPrecio().toString());
            Picasso.get()
                    .load(miproducto.getUrl_img())
                    .error(R.drawable.ic_launcher_background)
                    .into(IvProducto);


            if(onItemClickListener !=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(miproducto,getAdapterPosition());
                    }
                });

                btnErase.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItembtnEraseClick(miproducto,getAdapterPosition());

                    }
                });


            }



        }
    }
    public interface OnItemClickListener {
        void onItemClick(Producto producto, int posicion);
        void onItembtnEraseClick(Producto producto, int posicion);
    }
}

