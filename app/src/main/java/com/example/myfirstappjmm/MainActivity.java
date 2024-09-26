package com.example.myfirstappjmm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i("Ciclo de vida","Ha entrado en el metodo onCreate");

        /* Obtenemos los componentes asignados a la vista XML mediante findViewById --> buscamos
        * por ID */
        TextView txtMain = findViewById(R.id.txtMain);
        Button btnSendMessage = findViewById(R.id.btnSendMessage);

        /*A continuacion, le asignaremos un evento al boton creado dentro de la vista */

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Nuestra finalidad es dirigirnos a la segunda activity, para ello, debemos crear una instancia
                * de Intent --> Intent "name" = new Intent (state actual activity, activity where we want go) */

                Intent secondActivity = new Intent(MainActivity.this,SecondActivity.class);

                /*Tras esto, se hace un llamamiento a la segunda activity */
                startActivity(secondActivity);




            }
        });



    }
}