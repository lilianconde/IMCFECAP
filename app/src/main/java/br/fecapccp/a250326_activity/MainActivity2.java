package br.fecapccp.a250326_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btnCalculoIMC;
    private Button btnLimpar;

    private Button btnFechar;

    private EditText pesoText;

    private EditText alturaText;

    private float altura;

    private float peso;

    private float IMC;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btnCalculoIMC = findViewById(R.id.btnT2Calcular);
        btnCalculoIMC.setOnClickListener(view ->{
            CalcularIMC();
            ClassificacaoIMC();
            intent.putExtra("peso",peso);
            intent.putExtra("altura",altura);
            intent.putExtra("imc",IMC);
            startActivity(intent);
            finish();
        });

        btnLimpar = findViewById(R.id.btnT2Limpar);
        btnLimpar.setOnClickListener(view ->{
            LimparText();
        });

        btnFechar = findViewById(R.id.btnT2Fechar);
        btnFechar.setOnClickListener(view ->{
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void CalcularIMC(){
        pesoText = findViewById(R.id.editTextPesoT2);
        alturaText = findViewById(R.id.editTextAlturaT2);

        altura = Float.parseFloat(alturaText.getText().toString());
        peso = Float.parseFloat(pesoText.getText().toString());
        IMC = peso/(altura*altura);
    }

    private void LimparText(){
        pesoText = findViewById(R.id.editTextPesoT2);
        alturaText = findViewById(R.id.editTextAlturaT2);

        pesoText.setText("");
        alturaText.setText("");
    }

    private void ClassificacaoIMC(){
        if(IMC < 18.5){
            intent = new Intent(this, MainActivity3.class);
        }else if(IMC>=18.5 && IMC <25){
            intent = new Intent(this, MainActivity4.class);
        }else if(IMC>=25 && IMC<30){
            intent = new Intent(this, MainActivity5.class);
        }else if(IMC>=30 && IMC<35){
            intent = new Intent(this, MainActivity6.class);
        }else if (IMC>=35 && IMC<40){
            intent = new Intent(this, MainActivity7.class);
        } else if(IMC>=40){
            intent = new Intent(this, MainActivity8.class);
        }
    }
}