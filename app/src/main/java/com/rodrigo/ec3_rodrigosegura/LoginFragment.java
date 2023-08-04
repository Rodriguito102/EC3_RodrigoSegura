package com.rodrigo.ec3_rodrigosegura;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewError;

    public LoginFragment() {
        // Constructor vacío requerido.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        textViewError = view.findViewById(R.id.textViewError);

        // Agregar TextWatcher para validar los campos de inicio de sesión
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateForm();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        editTextEmail.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí debes validar la contraseña, por ejemplo, comparándola con un valor fijo como "Peru123"
                // Si la contraseña es correcta, muestra el fragmento del menú, de lo contrario, muestra un mensaje de error.
                String password = editTextPassword.getText().toString().trim();
                if (password.equals("Peru123")) {
                    showMenuFragment();
                } else {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Contraseña incorrecta");
                }
            }
        });

        // Deshabilitar el botón de inicio de sesión al iniciar la pantalla
        buttonLogin.setEnabled(false);

        return view;
    }

    private void validateForm() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        boolean isValid = !email.isEmpty() && !password.isEmpty();
        buttonLogin.setEnabled(isValid);
    }

    private void showMenuFragment() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MenuFragment())
                .commit();
    }
}
