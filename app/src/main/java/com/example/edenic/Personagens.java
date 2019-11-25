package com.example.edenic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Personagens extends AppCompatActivity {

    final ArrayList<String> nome = new ArrayList<>();
    final ArrayList<String> nivel = new ArrayList<>();
    final ArrayList<String> classe = new ArrayList<>();
    final ArrayList<String> raca= new ArrayList<>();
    final ArrayList<String> background = new ArrayList<>();

    RecyclerView rv2;
    RecyclerView.LayoutManager mRv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagens);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rv2 = findViewById(R.id.recyclerviewPersonagens);
        setAdapter();
        
        FloatingActionButton button = findViewById(R.id.addChar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPersonagem();
            }
        });
    
        FloatingActionButton button2 = findViewById(R.id.charUpdate);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePersonagem();
            }
        });



        
    }

    public void AddPersonagem() {
        Intent intent = new Intent(Personagens.this, AddPersonagem.class);
        startActivity(intent);
    }

    public void updatePersonagem() {
        rv2 = findViewById(R.id.recyclerviewPersonagens);
        setAdapter();
        
        this.finish();
        Intent intent = new Intent(Personagens.this, Personagens.class);
        startActivity(intent);
}

    public void setAdapter(){
        DatabaseHandler banco = new DatabaseHandler(this);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from personagens", new String[]{});

        cursor.moveToFirst();
        do {
            nome.add(cursor.getString(1));
            nivel.add(cursor.getString(2));
            classe.add(cursor.getString(4));
            raca.add(cursor.getString(3));
            background.add(cursor.getString(5));
            Log.i("aaa", cursor.getString(1));
        } while (cursor.moveToNext());
        PersonagensRecycler adapter = new PersonagensRecycler(this, nome, nivel, classe, raca, background);
        rv2.setAdapter(adapter);
        mRv2 = new GridLayoutManager(this.getBaseContext(), 1);
        rv2.setLayoutManager(mRv2);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
