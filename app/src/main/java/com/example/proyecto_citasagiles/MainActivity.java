package com.example.proyecto_citasagiles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.proyecto_citasagiles.persistencia.DbUsuarios;
import com.google.android.material.button.MaterialButton;

// Importar: Indica llamar las clases y archivos
// Extender: Indica usar la clase principal en las clases scundarias

public class MainActivity extends AppCompatActivity {
    // Dialog
    // private Dialog dialog;
    // private Button ShowDialog;
    EditText username, password;
    Button loginbtn, btnRegis; // Declaramos de forma global nuestra variable Button
    DbUsuarios DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); // Eliminamos la barrar superior

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton btnRegis = (MaterialButton) findViewById(R.id.btnRegis); // NEW

        // Conetext = La clase en la que estamos ubicados ahora mismo
        DB = new DbUsuarios(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString(); // Tomar los datos que agregó el usuario
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this, "Todos los espacios son requeridos", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkcontrasena(user, pass);
                    if (checkuserpass == true) {
                        // Toast.makeText(MainActivity.this, "Login correcto", Toast.LENGTH_SHORT).show();
                        Dialogo d = new Dialogo(MainActivity.this,"¿Está seguro que desea ingresar?","Citas Ágiles", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), menuprincipal.class);
                                startActivity(intent);
                            }
                        });
                    } else {
                        Toast.makeText(MainActivity.this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiamos de layout/Vista
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }




//         Dialog dialog;
//
//         dialog = new Dialog(MainActivity.this);
//         dialog.setContentView(R.layout.custom_dialog);
//         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//             dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background4));
//
//         }
//
//         dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background2));
//         dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//         dialog.setCancelable(false);
//
//         Button Okey = dialog.findViewById(R.id.btn_okay);
//         Button Cancel = dialog.findViewById(R.id.btn_cancel);
//
//         Okey.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//                 Toast.makeText(MainActivity.this, "Okay", Toast.LENGTH_SHORT).show();
//                 dialog.dismiss();
//             }
//         });

//         Cancel.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//                 Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
//                 dialog.dismiss();
//             }
//        });


//         ShowDialog.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//                 dialog.show(); // Showing the dialog here
//             }
//         });

        //fin del codigo

//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                    Toast.makeText(MainActivity.this, "Usuario correcto", Toast.LENGTH_SHORT).show();
//                }else
//                    Toast.makeText(MainActivity.this,"Usuario no registrado", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }

    //    @Override
    //   public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    //        int opt = item.getItemId();
    //    float valor;

//        switch(opt){
//            case R.id.registrar:
//                // Instanciamos nuestro objeto "cambiar"
//                Intent cambiar = new Intent(MainActivity.this, Registro.class);
//                startActivity(cambiar);
//                return true;
//            case R.id.recuperarpass:
//                // Instanciamos nuestro objeto "cambiar"
//                Intent cam = new Intent(MainActivity.this, Password.class);
//                startActivity(cam);
//                return true;
//            case R.id.salir:
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);

//        }
//    }

    public void regis(View m){
        // Instanciamos nuestro objeto "cambiar"
        Intent cambiar = new Intent(MainActivity.this, Registro.class);
        startActivity(cambiar);


    }
    public void ingresar(View m){
        // Instanciamos nuestro objeto "cambiar"
        Intent cambiar = new Intent(MainActivity.this, menuprincipal.class);
        startActivity(cambiar);


    }
    public void recu(View m){
        // Instanciamos nuestro objeto "cambiar"
        Intent cambiar = new Intent(MainActivity.this, Password.class);
        startActivity(cambiar);


    }



}