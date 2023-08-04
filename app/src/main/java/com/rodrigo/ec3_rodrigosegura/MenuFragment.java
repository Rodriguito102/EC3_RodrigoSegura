package com.rodrigo.ec3_rodrigosegura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewMenu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Arroz Chaufa", "Arroz Chaufa: Fusion peruano-china deliciosamente salteada.", "https://www.laylita.com/recetas/wp-content/uploads/2022/12/Receta-del-arroz-chaufa-peruano-1024x683.jpg", "Arroz, pollo, huevo, cebolla, ajos, sillao, etc.", 12.99));
        menuItems.add(new MenuItem("Sopa de pollo", "Sopa reconfortante con pollo tierno y verduras.", "https://cocina-casera.com/wp-content/uploads/2017/12/Sopa-de-pollo.jpg", "Pollo, zanahoria, papa, apio, fideos, etc.", 8.50));
        menuItems.add(new MenuItem("Pollo a la brasa", "Pollo asado a la parrilla con sabrosas especias.", "URL_de_la_imagen1", "Pollo, ajo, cerveza, especias, etc.", 10.75));
        menuItems.add(new MenuItem("Seco de carne", "Delicioso estofado de carne con aderezo especial.", "URL_de_la_imagen1", "Carne de res, cerveza, chicha de jora, ajos, etc.", 14.50));
        menuItems.add(new MenuItem("Tallarines rojos", "Tallarines en salsa de tomate con carne y verduras.", "URL_de_la_imagen1", "Tallarines, carne molida, tomate, cebolla, etc.", 9.99));
        menuItems.add(new MenuItem("Tallarines verdes", "Tallarines en salsa verde de albahaca con trozos de pollo.", "URL_de_la_imagen1", "Tallarines, albahaca, espinaca, pollo, etc.", 11.25));
        menuItems.add(new MenuItem("Tallarines al alfredo", "Tallarines en salsa cremosa y rica de queso.", "URL_de_la_imagen1", "Tallarines, crema de leche, queso parmesano, mantequilla, etc.", 13.50));
        menuItems.add(new MenuItem("Pollo a la plancha", "Pollo jugoso y tierno cocinado a la parrilla.", "URL_de_la_imagen1", "Pechuga de pollo, aceite de oliva, limón, hierbas, etc.", 9.75));
        menuItems.add(new MenuItem("Guiso de carne", "Deliciosa mezcla de carne y verduras en un caldo reconfortante.", "URL_de_la_imagen1", "Carne de res, papas, zanahorias, arvejas, etc.", 12.25));
        menuItems.add(new MenuItem("Frejoles", "Frijoles suaves y sabrosos preparados con especias y acompañamientos.", "URL_de_la_imagen1", "Frejoles, cebolla, ajos, ají, carne de cerdo, etc.", 8.99));



        menuAdapter = new MenuAdapter(menuItems);
        recyclerView.setAdapter(menuAdapter);

        return view;
    }
}
