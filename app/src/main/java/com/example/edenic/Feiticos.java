package com.example.edenic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
//import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Feiticos extends AppCompatActivity {

    //       private RecyclerView.LayoutManager mRv;
    final ArrayList<String> spell_nome = new ArrayList<>();
    final ArrayList<String> spell_nivel = new ArrayList<>();
    final ArrayList<String> spell_cast_time = new ArrayList<>();
    final ArrayList<String> spell_range = new ArrayList<>();
    final ArrayList<String> spell_duration = new ArrayList<>();
    final ArrayList<String> spell_classe = new ArrayList<>();
    final ArrayList<String> spell_desc = new ArrayList<>();
    
    RecyclerView rv;
    RecyclerView.LayoutManager mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feiticos);

        rv = findViewById(R.id.rvtoper);

        setAdapter();
        
        //spn sort
        
        String [] spnSort = new String[]{"Alfabético","Classe","Nível"};
        Spinner spinner = (Spinner) findViewById(R.id.spnSort);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spnSort);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (adapter.equals("Aflabpetico")){
                    Collections.sort(spell_nome);
                    Toast.makeText(Feiticos.this, "top", Toast.LENGTH_SHORT).show();
                }
                else if(adapter.equals("Classe")){
                    Collections.sort(spell_classe);
                    Toast.makeText(Feiticos.this, "top2", Toast.LENGTH_SHORT).show();
                }
                else if(adapter.equals("Nível")){
                    Collections.sort(spell_nivel);
                    Toast.makeText(Feiticos.this, "top3", Toast.LENGTH_SHORT).show();
                }
            }
    
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
        
            }
        });
        
        //spn sort

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    public void setAdapter(){
        DatabaseHandler banco = new DatabaseHandler(this);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from feiticos", new String[]{});

        cursor.moveToFirst();
        do {
            spell_nome.add(cursor.getString(1));
            spell_nivel.add(cursor.getString(2));
            spell_cast_time.add(cursor.getString(3));
            spell_range.add(cursor.getString(4));
            spell_duration.add(cursor.getString(5));
            spell_classe.add(cursor.getString(6));
            spell_desc.add(cursor.getString(7));
        } while (cursor.moveToNext());
        FeiticosRecycler adapter = new FeiticosRecycler(this, spell_nome, spell_nivel, spell_cast_time, spell_range, spell_duration, spell_classe, spell_desc);
        rv.setAdapter(adapter);
        mRv = new GridLayoutManager(this.getBaseContext(), 1);
        rv.setLayoutManager(mRv);
    }




    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
