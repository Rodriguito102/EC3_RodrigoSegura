package com.rodrigo.ec3_rodrigosegura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePlatilloFragment extends Fragment {

    public static DetallePlatilloFragment newInstance(MenuItem menuItem) {
        DetallePlatilloFragment fragment = new DetallePlatilloFragment();
        Bundle args = new Bundle();
        args.putParcelable("menuItem", menuItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_platillo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageViewLargeDish = view.findViewById(R.id.imageViewLargeDish);
        TextView textViewDishName = view.findViewById(R.id.textViewDishName);
        TextView textViewDescription = view.findViewById(R.id.textViewDescription);
        TextView textViewIngredients = view.findViewById(R.id.textViewIngredients);
        TextView textViewPrice = view.findViewById(R.id.textViewPrice);


        MenuItem menuItem = getArguments().getParcelable("menuItem");
        if (menuItem != null) {

            imageViewLargeDish.setImageResource(R.drawable.placeholder);
            textViewDishName.setText(menuItem.getName());
            textViewDescription.setText(menuItem.getDescription());
            textViewIngredients.setText(menuItem.getIngredients());
            textViewPrice.setText(getString(R.string.price_format, menuItem.getPrice()));
        }
    }
}
