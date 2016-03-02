package com.example.antonio.roteiro02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((Button)findViewById(R.id.TRADUZIR)).setOnClickListener(new Traduzir("TRADUZIR",null));
        ((Button)findViewById(R.id.INGLES)).setOnClickListener(new Traduzir("TRADUZIR", "INGLES"));
        ((Button)findViewById(R.id.FRANCES)).setOnClickListener(new Traduzir("TRADUZIR", "FRANCES"));

    }

    private boolean verificaCampo(TextView texto) {
        String cor = texto.getText().toString();
        View focus = null;

        if (TextUtils.isEmpty(cor)) {
            texto.setError("Campo Vazio!"); //mostra q tem erro
            focus = texto;
            focus.requestFocus(); // joga na tela
        }
        if (cor.equalsIgnoreCase("azul") || cor.equalsIgnoreCase("amarelo") || cor.equalsIgnoreCase("vermelho")) {
            return true;
        } else {
            if (!TextUtils.isEmpty(cor)) {
                texto.setError("Cor inválida, digite azul, amarelo ou vermelho!");
                focus = texto;
                focus.requestFocus(); // joga na tela

            }
            return false;
        }
    }

    private class Traduzir implements View.OnClickListener {
        private String action;
        private String category;

        Traduzir(String action, String category){
            this.action = action;
            this.category = category;
        }

        @Override
        public void onClick(View v) {

            EditText texto = ((EditText)findViewById(R.id.COR));
            String textoS = texto.getText().toString();

            if(verificaCampo(texto)){
                Intent i = new Intent(this.action);
                if(this.category != null)
                    i.addCategory(this.category);
                Bundle b = new Bundle();
                b.putString("cor", textoS);
                i.putExtras(b);
                startActivity(i);
            }
        }
    }
}
