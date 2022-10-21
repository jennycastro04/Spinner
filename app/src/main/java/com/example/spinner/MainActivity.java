package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private Spinner spinner;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        spinner= findViewById(R.id.spinner);
        String []opciones={"Seleccionar","Sumar","Restar","Multiplicar","Dividir","Raiz","Potencia","Todas","Ninguna"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner.setAdapter(adapter);
    }

    public void Operacion(View view){
        String v1 = et1.getText().toString();
        String v2 = et2.getText().toString();
        int vl1 = Integer.parseInt(v1);
        int vl2 = Integer.parseInt(v2);
        int sum = vl1 + vl2;
        int res = vl1 - vl2;
        int mu = vl1 * vl2;
        double div = (double)vl1 / vl2;
        double pot = Math.pow(vl1, vl2);
        double ra1 = Math.sqrt(vl1);
        double ra2 = Math.sqrt(vl2);
        String s = spinner.getSelectedItem().toString();

        if(s.equals("Sumar")){
            String msj = String.valueOf(sum);
            tv1.setText(msj);
        }
        if (s.equals("Restar")){
            String msj = String.valueOf(res);
            tv1.setText(msj);
        }
        if (s.equals("Multiplicar")){
            String msj = String.valueOf(mu);
            tv1.setText(msj);
        }
        if (s.equals("Dividir")){
            if(vl2!=0){
                String msj = String.valueOf(div);
                tv1.setText(msj);
            }else{
                tv1.setText("No es posible dividir entre 0");
            }
        }
        if (s.equals("Raiz")){
            String msj = "La raiz del primer valor: "+ra1+"\n La raiz para el segundo valor: "+ra2;
            tv1.setText(msj);
        }
        if (s.equals("Potencia")){
            String msj = String.valueOf(pot);
            tv1.setText(msj);
        }

        if (s.equals("Todas")){
            String msj = "La suma es: "+sum+ ", La resta es: "+res+", La multiplicación es: "+mu+", La division es: "+div+", La potencia es: "+pot+"" +
                    ", La raiz #1: "+ra1+", La raiz #2: "+ra2;
            tv1.setText(msj);
        }
        if (s.equals("Ninguna")){
            String msj = "No se hará ninguna operación";
            tv1.setText(msj);
        }
    }
}