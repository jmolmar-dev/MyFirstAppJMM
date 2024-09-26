package com.example.myfirstappjmm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i("Ciclo de vida", "Ha entrado en el metodo onCreate");

        /*Volvemos a llamar a los componentes de la vista XML (findViewById) */
        EditText etMain = findViewById(R.id.etMain);
        EditText etIntegerNumber = findViewById(R.id.etIntegerNumber);
        EditText etDecimalNumber = findViewById(R.id.etDecimalNumber);
        Switch sw1 = findViewById(R.id.sw1);
        Button btnSend2 = findViewById(R.id.btnSend2);
        Button btnBack = findViewById(R.id.btnBack);

        /*Nuevamente, se le aplicara funcionalidad a un boton de la vista secundaria*/
        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etMain.getText().toString().equals("")){
                    Toast toastText = new Toast(SecondActivity.this);
                    toastText.setText("You must write in Main Text");
                    toastText.show();
                }else if (etIntegerNumber.getText().toString().equals("")){
                    Toast toastInteger = new Toast(SecondActivity.this);
                    toastInteger.setText("You must insert a Integer Number");
                    toastInteger.show();
                }else if (etDecimalNumber.getText().toString().equals("")){
                    Toast toastDecimal = new Toast(SecondActivity.this);
                    toastDecimal.setText("You must insert a Double Number");
                    toastDecimal.show();
                }else if (!sw1.isChecked()){
                    Toast toastSwitch = new Toast(SecondActivity.this);
                    toastSwitch.setText("Switch must be activated");
                    toastSwitch.show();
                }else{
                    /*Volvemos a crear una instancia de Intent con el objetivo de navegar hacia otra activity */
                    Intent intentThirdActivity = new Intent(SecondActivity.this,ThirdActivity.class);


                    /* Momento de incluir las claves valor dentro del intent*/
                    intentThirdActivity.putExtra("etMain",etMain.getText().toString());

                        //Los valores del Integer, del Double y el boolean del switch tendremos que traerlos mediante variables para ser introducidos luegos:
                    int etIntegerNumber2 = Integer.parseInt(etIntegerNumber.getText().toString());
                    double etDoubleNumber2 = Double.parseDouble(etDecimalNumber.getText().toString());
                    boolean switchActivated = sw1.isChecked();
                    intentThirdActivity.putExtra("etInteger", etIntegerNumber2);
                    intentThirdActivity.putExtra("etDecimal",etDoubleNumber2);
                    intentThirdActivity.putExtra("switchActivated",switchActivated);

                    /* Comprobaciones de Log*/
                    Log.i("etMain", etMain.getText().toString());
                    Log.i("etInteger",Integer.toString(etIntegerNumber2));
                    Log.i("etDecimal",Double.toString(etDoubleNumber2));
                    Log.i("switch", Boolean.toString(switchActivated));

                    /*Se comienza la siguiente actividad*/
                    startActivity(intentThirdActivity);


                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackToMain = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intentBackToMain);
            }
        });




    }
}