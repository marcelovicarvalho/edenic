package com.example.edenic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class AddPersonagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personagem);

    //spinner classe
        List<String> classes =  new ArrayList<String>();
        classes.add("Barbaro");
        classes.add("Ladino");
        classes.add("Mago");
        classes.add("Clerigo");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, classes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spnClasse);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    //spinner raça
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

        sItems2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getSelectedItem().equals("Humano")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
                else if(adapterView.getSelectedItem().equals("Anão")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
                else if(adapterView.getSelectedItem().equals("Elfo")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
                else if(adapterView.getSelectedItem().equals("Halfling")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    RadioButton rdb1 = findViewById(R.id.rdb1);
                    rdb1.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    //spinner background
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
//        String selected3 = sItems3.getSelectedItem().toString();
//        if (selected3.equals("Acolita")) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "Acolita selecionado",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//        }
//        else if (selected3.equals("Charlatão")){
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "Charlatão selecionado",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//        }
        sItems3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
