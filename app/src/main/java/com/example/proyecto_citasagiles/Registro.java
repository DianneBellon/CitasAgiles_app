package com.example.proyecto_citasagiles;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_citasagiles.persistencia.DbUsuarios;


public class Registro extends AppCompatActivity {
    EditText tipoid, numid, username1, password1, repassword, correo;
    Button btnRegistro, volverSingin; // Variable Global
    DbUsuarios DB;

    // Ciclo de vida de android = se ejecuta al iniciar nuestra activity onCreate, onStart, onResume.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        tipoid = findViewById(R.id.tipoid);
        numid = findViewById(R.id.numid);
        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        repassword = findViewById(R.id.repassword);
        correo = findViewById(R.id.correo);

        btnRegistro = findViewById(R.id.btnRegistro);
        volverSingin = findViewById(R.id.volverSingin);
        DB = new DbUsuarios(this);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tdoc = tipoid.getText().toString();
                String ndoc = numid.getText().toString();
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                String repass = repassword.getText().toString();
                String email = correo.getText().toString();

                if(TextUtils.isEmpty(tdoc) || TextUtils.isEmpty(ndoc) || TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) || TextUtils.isEmpty(email))
                    Toast.makeText(Registro.this, "Se requiere llenar los campos", Toast.LENGTH_SHORT).show();
                else
                if(pass.equals(repass)){
                    Boolean checkuser = DB.checknomusuario(user);
                    if(checkuser == false){
                        Boolean insert = DB.insertarUsuario(tdoc, ndoc, user, email, pass);
                        if(insert ==true){
                            Toast.makeText(Registro.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Registro.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Registro.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Registro.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                }

            }
        });

        volverSingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }
}


//        tipoid = findViewById(R.id.tipoid);
//        numid = findViewById(R.id.numid);
//        username1 = findViewById(R.id.username1);
//        apellidos = findViewById(R.id.apellidos);
//        email = findViewById(R.id.email);
//        password1= findViewById(R.id.password1);
//        btnRegistro = findViewById(R.id.btnRegistro);
//        volverSingin = findViewById(R.id.volverSingin);

//        btnRegistro.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                String tipo = tipoid.getText().toString();
//                String num = tipoid.getText().toString();
//                String user = tipoid.getText().toString();
//                String apel = tipoid.getText().toString();
//                String correo = tipoid.getText().toString();
//                String pass = tipoid.getText().toString();
//                String repass = tipoid.getText().toString();
//
//                if(TextUtils.isEmpty(tipo) || TextUtils.isEmpty(num) || TextUtils.isEmpty(user) || TextUtils.isEmpty(user) || TextUtils.isEmpty(apel) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(pass))
//                    Toast.makeText(Registro.this, "Se requiere llenar los campos", Toast.LENGTH_SHORT).show();
//                else
//                if(pass.equals(repass)){
//                    Boolean checkuser = DB.checknomusuario(user);
//                    if(checkuser == false){
//                        Boolean insert =DB.insertarUsuario(user, pass);
//                    }
//                    if(insert == true){
//                        Toast.makeText(Registro.this, "Rgistrado correctamenta", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(Registro.this, "Rgistro fallido", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(Registro.this, "Rgistro exitoso", Toast.LENGTH_SHORT).show();
//                    }
//                }

//            });

//        volverSingin.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {

//                }
//            });

//            @Override
//            public void onClick(View view) {
//                DbHelper dbHelper = new DbHelper(Registro.this);
//                SQLiteDatabase db = dbHelper.getWritableDatabase(); //Crearla = Escribir
//                // Validación
//                if(db != null){
//                    Toast.makeText(Registro.this, "BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
//                }else {
//                    Toast.makeText(Registro.this,"ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
//                }

//          }
//        });

//        }

//    }
//}
