package com.example.myfirstappjmm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*Se cargaran los componentes de la vista nuevamente */
        TextView tw1 = findViewById(R.id.tw1);
        TextView tw2 = findViewById(R.id.tw2);
        TextView tw3 = findViewById(R.id.tw3);
        TextView tw4 = findViewById(R.id.tw4);
        Button btnHome = findViewById(R.id.btnHome);




        /*Obtenemos los resultados del Activity anterior y los seteamos dentro de los campos*/
        Intent resultsForSecondActivity = getIntent();

        String etMain = resultsForSecondActivity.getStringExtra("etMain");
        int etInteger = resultsForSecondActivity.getIntExtra("etInteger",0);
        double etDecimal = resultsForSecondActivity.getDoubleExtra("etDecimal",0.0);
        boolean switchActivated = resultsForSecondActivity.getBooleanExtra("switchActivated",false);

        tw1.setText(etMain);
        tw2.setText(String.valueOf(etInteger));
        tw3.setText(String.valueOf(etDecimal));
        tw4.setText(String.valueOf(switchActivated));

        /*Por ultimo, tendremos que darle funcionalidad al boton para volver a la pagina principal */
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intentHome);
            }
        });



    }
}