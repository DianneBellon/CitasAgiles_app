package com.example.proyecto_citasagiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    TextView singin;

    //Dialog
//     private Dialog dialog;
//     private Button ShowDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singin = findViewById(R.id.singin);

        //Dialog
//         ShowDialog = findViewById(R.id.loginbtn);



        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);


        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int opt = item.getItemId();
        float valor;

        switch(opt){
            case R.id.registrar:
                // Instanciamos nuestro objeto "cambiar"
                Intent cambiar = new Intent(MainActivity.this, Registro.class);
                startActivity(cambiar);
                return true;
            case R.id.recuperarpass:
                // Instanciamos nuestro objeto "cambiar"
                Intent cam = new Intent(MainActivity.this, Password.class);
                startActivity(cam);
                return true;
            case R.id.salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void ingresar(View m){
        // Instanciamos nuestro objeto "cambiar"
        Intent cambiar = new Intent(MainActivity.this, Productos.class);
        startActivity(cambiar);
    }



}