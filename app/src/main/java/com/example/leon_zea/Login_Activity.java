package com.example.leon_zea;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    private EditText etmail, etpasswd;
    private SharedPreferences mispreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        referenciar();

        mispreferencias = getSharedPreferences("tienda_app", MODE_PRIVATE);

        if (mispreferencias.getBoolean("logueado", false) == true) {
            Intent miIntent = new  Intent(this, MainActivity.class);
            startActivity(miIntent);
            finish();
        }

    }

    private void referenciar() {
        etmail = findViewById(R.id.etmail);
        etpasswd = findViewById(R.id.etpasswd);
    }

    public void ClickIniciarSesion(View view) {
        String Pass = "123456";
        String User = "Yo";

        String passUser = etpasswd.getText().toString();
        String userUser = etmail.getText().toString();

        if (Pass.equals(passUser) && User.equals(userUser)) {
            SharedPreferences.Editor mieditor=mispreferencias.edit();
            mieditor.putBoolean("logueado",true);
            mieditor.apply();
            Intent miIntent = new Intent(this, MainActivity.class);
            startActivity(miIntent);
            finish();
        } else {
            Toast.makeText(this, "No mi carnalito no tas en el registro", Toast.LENGTH_SHORT).show();
        }
    }
}