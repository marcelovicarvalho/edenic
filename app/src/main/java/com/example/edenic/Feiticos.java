package com.example.edenic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;

public class Feiticos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String fileName = "data.txt";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feiticos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
