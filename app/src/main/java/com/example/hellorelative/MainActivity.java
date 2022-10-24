 package com.example.hellorelative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

     private int numero;

     private Button mtoast;
     private Button mNextButton;
     private TextView mTextView;
     private  int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoast = (Button) findViewById(R.id.button_toast);
        mNextButton = (Button) findViewById(R.id.button_count);
        mTextView = (TextView) findViewById(R.id.show_count);


        //ClickListener para cuando pulsar llamar al metodo que sume 1 y lo muestre
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber();
                mTextView.setText(""+number);
            }
        });


        mtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(getApplicationContext(),"El numero es"+number, Toast.LENGTH_SHORT);
                toast1.show();
            }
        });


    }
     //Para guardar el valor del numero cuando canvie la horientacion
     @Override
     protected void onSaveInstanceState(Bundle outState){
         super.onSaveInstanceState(outState);
         outState.putInt("numero",number);
     }
     @Override
     protected void onRestoreInstanceState(Bundle savedInstanceState){
         super.onRestoreInstanceState(savedInstanceState);
         numero = savedInstanceState.getInt("numero");
         mTextView.setText(String.valueOf(numero));
     }

     //Metodo para sumar 1
     private int updateNumber(){
         number = number +1;
         return number;
     }
 }
