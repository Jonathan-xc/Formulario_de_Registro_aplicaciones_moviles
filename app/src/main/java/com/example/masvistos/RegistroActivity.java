package com.example.masvistos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private Button loginButton, registerButton, loginSubmitButton, registerSubmitButton;
    private EditText emailLoginInput, passwordLoginInput;
    private EditText usernameRegisterInput, emailRegisterInput, passwordRegisterInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        emailLoginInput = findViewById(R.id.emailLoginInput);
        passwordLoginInput = findViewById(R.id.passwordLoginInput);
        usernameRegisterInput = findViewById(R.id.usernameRegisterInput);
        emailRegisterInput = findViewById(R.id.emailRegisterInput);
        passwordRegisterInput = findViewById(R.id.passwordRegisterInput);

        loginSubmitButton = findViewById(R.id.loginSubmitButton);
        registerSubmitButton = findViewById(R.id.registerSubmitButton);

        // Predeterminado para la opción de Login
        setLoginMode();

        loginButton.setOnClickListener(v -> setLoginMode());
        registerButton.setOnClickListener(v -> setRegisterMode());

        registerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameRegisterInput.getText().toString();
                String email = emailRegisterInput.getText().toString();
                String password = passwordRegisterInput.getText().toString();

                if (username.isEmpty() || !isValidEmail(email) || !isValidPassword(password)) {
                    Toast.makeText(RegistroActivity.this, "Por favor, ingrese información válida.", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí iría el código para registrar al usuario
                    Toast.makeText(RegistroActivity.this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailLoginInput.getText().toString();
                String password = passwordLoginInput.getText().toString();

                if (!isValidEmail(email) || !isValidPassword(password)) {
                    Toast.makeText(RegistroActivity.this, "Credenciales inválidas.", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí iría el código para iniciar sesión
                    Toast.makeText(RegistroActivity.this, "Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Mostrar campos para Login y ocultar los de Registro
    private void setLoginMode() {
        emailLoginInput.setVisibility(View.VISIBLE);
        passwordLoginInput.setVisibility(View.VISIBLE);
        loginSubmitButton.setVisibility(View.VISIBLE); // Mostrar botón de "Iniciar sesión"

        usernameRegisterInput.setVisibility(View.GONE);
        emailRegisterInput.setVisibility(View.GONE);
        passwordRegisterInput.setVisibility(View.GONE);
        registerSubmitButton.setVisibility(View.GONE); // Ocultar botón de "Registrarse"

        loginButton.setAlpha(1f); // Resaltar el botón Login
        registerButton.setAlpha(0.5f); // Atenuar el botón Registro
    }

    // Mostrar campos para Registro y ocultar los de Login
    private void setRegisterMode() {
        emailLoginInput.setVisibility(View.GONE);
        passwordLoginInput.setVisibility(View.GONE);
        loginSubmitButton.setVisibility(View.GONE); // Ocultar botón de "Iniciar sesión"

        usernameRegisterInput.setVisibility(View.VISIBLE);
        emailRegisterInput.setVisibility(View.VISIBLE);
        passwordRegisterInput.setVisibility(View.VISIBLE);
        registerSubmitButton.setVisibility(View.VISIBLE); // Mostrar botón de "Registrarse"

        loginButton.setAlpha(0.5f); // Atenuar el botón Login
        registerButton.setAlpha(1f); // Resaltar el botón Registro
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
