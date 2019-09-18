package com.example.edenic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        CardView personagens = findViewById(R.id.personagens);
        personagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPersonagens();
            }
        });

        CardView feiticos = findViewById(R.id.feiticos);
        feiticos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openFeiticos();
            }
        });
    }
    public void openPersonagens(){
        Intent intent = new Intent(this, Personagens.class);
        startActivity(intent);
    }
    public void openFeiticos(){
        Intent intent = new Intent(this, Feiticos.class);
        startActivity(intent);
    }
}
