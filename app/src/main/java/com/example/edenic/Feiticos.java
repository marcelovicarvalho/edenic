package com.example.edenic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feiticos);
        RecyclerView.LayoutManager mRv;
        rv = findViewById(R.id.rvtoper);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        mRv = new GridLayoutManager(this.getBaseContext(),1);

        Context context;
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
        }
        while (cursor.moveToNext());
        }

        FeiticosRecycler adapter = new FeiticosRecycler(this,spell_nome,spell_nivel,spell_cast_time,spell_range,spell_duration,spell_classe);
        rv.


    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
