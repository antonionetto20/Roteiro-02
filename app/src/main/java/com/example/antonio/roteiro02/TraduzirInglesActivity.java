package com.example.antonio.roteiro02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TraduzirInglesActivity extends AppCompatActivity {

    private TextView mTraducao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traduzir_ingles);

        mTraducao = (EditText)findViewById(R.id.TRADUCAOI);
        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                String corS = b.getString("cor");

                if(corS.equalsIgnoreCase("AZUL")){
                    mTraducao.setText("BLUE");
                }else if(corS.equalsIgnoreCase("AMARELO")){
                    mTraducao.setText("YELLOW");
                }else{
                    mTraducao.setText("RED");
                }
            }
        }

        ((Button)findViewById(R.id.voltarI)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
