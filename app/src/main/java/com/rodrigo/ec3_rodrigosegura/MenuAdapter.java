package com.rodrigo.ec3_rodrigosegura;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rodrigo.ec3_rodrigosegura.MenuItem;
import com.rodrigo.ec3_rodrigosegura.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuItems;
    private Context context;

    public MenuAdapter(List<MenuItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;
    }

    public MenuAdapter(List<MenuItem> menuItems) {
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        holder.bind(menuItem);


    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewDish;
        private TextView textViewDishName;
        private TextView textViewDescription;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDish = itemView.findViewById(R.id.imageViewDish);
            textViewDishName = itemView.findViewById(R.id.textViewDishName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }

        public void bind(MenuItem menuItem) {
            textViewDishName.setText(menuItem.getName());
            textViewDescription.setText(menuItem.getDescription());

            // Cargar la imagen usando Coil o Picasso
            // Por ejemplo, usando Coil:
            ImageLoader imageLoader = Coil.imageLoader(itemView.getContext());
            ImageRequest request = new ImageRequest.Builder(itemView.getContext())
                    .data(menuItem.getImageUrl())
                    .crossfade(true)
                    .target(imageViewDish)
                    .build();
            imageLoader.enqueue(request);
        }
    }
}

