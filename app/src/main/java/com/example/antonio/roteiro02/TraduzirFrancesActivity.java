package com.example.antonio.roteiro02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TraduzirFrancesActivity extends AppCompatActivity {

    private TextView mTraducao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traduzir_frances);

        mTraducao = (EditText)findViewById(R.id.TRADUCAOF);
        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                String corS = b.getString("cor");

                if(corS.equalsIgnoreCase("AZUL")){
                    mTraducao.setText("BLEU");
                }else if(corS.equalsIgnoreCase("AMARELO")){
                    mTraducao.setText("JAUNE");
                }else{
                    mTraducao.setText("ROUGE");
                }
            }
        }

        ((Button)findViewById(R.id.voltarF)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
