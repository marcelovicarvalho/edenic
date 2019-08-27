package com.example.edenic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddPersonagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personagem);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<String> classes =  new ArrayList<String>();
        classes.add("Barbaro");
        classes.add("Ladino");
        classes.add("Mago");
        classes.add("Clerigo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, classes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spnClasse);
        sItems.setAdapter(adapter);

        String selected = sItems.getSelectedItem().toString();
        if (selected.equals("what ever the option was")) {
        }

//
        List<String> racas =  new ArrayList<String>();
        racas.add("Humano");
        racas.add("Anão");
        racas.add("Elfo");
        racas.add("Halfling");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, racas);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems2 = (Spinner) findViewById(R.id.spnRaca);
        sItems2.setAdapter(adapter2);

        String selected2 = sItems2.getSelectedItem().toString();
        if (selected.equals("what ever the option was")) {
        }

        List<String> background =  new ArrayList<String>();
        background.add("Acolita");
        background.add("Charlatão");
        background.add("Vigia");
        background.add("Criminoso");
        background.add("Viajante de longe");
        background.add("Pescador");
        background.add("Herói popular");
        background.add("Membro de guilda");
        background.add("Assombrado");
        background.add("Cavaleiro");
        background.add("Marinheiro");
        background.add("Mercenário veterano");
        background.add("De outras terras");
        background.add("Navegante");
        background.add("Soldado");
        background.add("Caçador de recompensas urbano");

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, background);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems3 = (Spinner) findViewById(R.id.spnBackground);
        sItems3.setAdapter(adapter3);

        String selected3 = sItems3.getSelectedItem().toString();
        if (selected.equals("what ever the option was")) {
        }
    }
}
