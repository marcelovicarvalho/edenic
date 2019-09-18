package com.example.edenic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
//import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Feiticos extends AppCompatActivity {
    final ArrayList<String> spell_nome = new ArrayList<>();

    //       private RecyclerView.LayoutManager mRv;
    final ArrayList<String> spell_nivel = new ArrayList<>();
    final ArrayList<String> spell_cast_time = new ArrayList<>();
    final ArrayList<String> spell_range = new ArrayList<>();
    final ArrayList<String> spell_duration = new ArrayList<>();
    final ArrayList<String> spell_classe = new ArrayList<>();
    RecyclerView rv;
    RecyclerView.LayoutManager mRv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feiticos);

        rv = findViewById(R.id.rvtoper);

        setAdapter();

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
            Toast.makeText(Feiticos.this, spell_cast_time.toString(), Toast.LENGTH_SHORT).show();
        } while (cursor.moveToNext());
        FeiticosRecycler adapter = new FeiticosRecycler(this, spell_nome, spell_nivel, spell_cast_time, spell_range, spell_duration, spell_classe);
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
