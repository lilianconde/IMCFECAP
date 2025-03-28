package br.fecapccp.a250326_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {
    private TextView pesoText;
    private TextView alturaText;
    private TextView IMCText;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        Bundle bundle = getIntent().getExtras();

        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        float IMC = bundle.getFloat("imc");

        pesoText = findViewById(R.id.textT6Peso);
        alturaText = findViewById(R.id.textT6Altura);
        IMCText = findViewById(R.id.textT6Imc);

        pesoText.setText("Peso: "+peso);
        alturaText.setText("Altura: "+altura);
        IMCText.setText("IMC: "+IMC);

        btnFechar = findViewById(R.id.btnT6Fechar);
        btnFechar.setOnClickListener(view ->{
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}