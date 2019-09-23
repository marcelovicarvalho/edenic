package com.example.edenic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
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
        setContentView(R.layout.activity_add_personagem2);

    //forca
        final CheckBox atletismo = findViewById(R.id.atletismo);

    //destreza
        final CheckBox acrobacia = findViewById(R.id.acrobacia);
        final CheckBox furtividade = findViewById(R.id.furtividade);
        final CheckBox prestigitacao = findViewById(R.id.prestigitacao);

    //inteligencia
        final CheckBox arcanismo = findViewById(R.id.arcanismo);
        final CheckBox historia = findViewById(R.id.historia);
        final CheckBox investigacao = findViewById(R.id.investigacao);
        final CheckBox natureza = findViewById(R.id.natureza);
        final CheckBox religiao = findViewById(R.id.religiao);

    //sabedoria
        final CheckBox adestraranimais = findViewById(R.id.adestraranimais);
        final CheckBox intuicao = findViewById(R.id.intuicao);
        final CheckBox medicina = findViewById(R.id.medicina);
        final CheckBox percepcao = findViewById(R.id.percepcao);
        final CheckBox sobrevivencia = findViewById(R.id.sobrevivencia);

    //carisma
        final CheckBox atuacao = findViewById(R.id.atuacao);
        final CheckBox enganacao = findViewById(R.id.enganacao);
        final CheckBox intimidacao = findViewById(R.id.intimidacao);
        final CheckBox persuasao = findViewById(R.id.persuasao);

    //populando o number picker
        NumberPicker forca = (NumberPicker) findViewById(R.id.forca);
        NumberPicker destreza = (NumberPicker) findViewById(R.id.destreza);
        NumberPicker inteligencia = (NumberPicker) findViewById(R.id.inteligencia);
        NumberPicker sabedoria = (NumberPicker) findViewById(R.id.sabedoria);
        NumberPicker carisma = (NumberPicker) findViewById(R.id.carisma);

        String[] nums = new String[21];
        for(int i=0; i<nums.length; i++)
            nums[i] = Integer.toString(i);

    //forca
        forca.setMinValue(1);
        forca.setMaxValue(21);
        forca.setWrapSelectorWheel(false);
        forca.setDisplayedValues(nums);
        forca.setValue(9);

    //destreza
        destreza.setMinValue(1);
        destreza.setMaxValue(21);
        destreza.setWrapSelectorWheel(false);
        destreza.setDisplayedValues(nums);
        destreza.setValue(9);

    //inteligencia
        inteligencia.setMinValue(1);
        inteligencia.setMaxValue(21);
        inteligencia.setWrapSelectorWheel(false);
        inteligencia.setDisplayedValues(nums);
        inteligencia.setValue(9);

    //sabedoria
        sabedoria.setMinValue(1);
        sabedoria.setMaxValue(21);
        sabedoria.setWrapSelectorWheel(false);
        sabedoria.setDisplayedValues(nums);
        sabedoria.setValue(9);

    //carisma
        carisma.setMinValue(1);
        carisma.setMaxValue(21);
        carisma.setWrapSelectorWheel(false);
        carisma.setDisplayedValues(nums);
        carisma.setValue(9);

    //spinner classe
        List<String> classes =  new ArrayList<String>();
        classes.add("Clerigo");
        classes.add("Guerreiro");
        classes.add("Ladino");
        classes.add("Mago");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, classes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spnClasse);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if (adapterView.getSelectedItem().equals("Clerigo")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    resetaBotoes();
                    historia.setEnabled(true);
                    intuicao.setEnabled(true);
                    medicina.setEnabled(true);
                    persuasao.setEnabled(true);
                    religiao.setEnabled(true);
                }
                else if(adapterView.getSelectedItem().equals("Guerreiro")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    resetaBotoes();
                    acrobacia.setEnabled(true);
                    adestraranimais.setEnabled(true);
                    atletismo.setEnabled(true);
                    historia.setEnabled(true);
                    intuicao.setEnabled(true);
                    intimidacao.setEnabled(true);
                    percepcao.setEnabled(true);
                    sobrevivencia.setEnabled(true);
                }
                else if(adapterView.getSelectedItem().equals("Ladino")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    resetaBotoes();
                    acrobacia.setEnabled(true);
                    atletismo.setEnabled(true);
                    atuacao.setEnabled(true);
                    furtividade.setEnabled(true);
                    intimidacao.setEnabled(true);
                    percepcao.setEnabled(true);
                    persuasao.setEnabled(true);
                    prestigitacao.setEnabled(true);
                }
                else if(adapterView.getSelectedItem().equals("Mago")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    resetaBotoes();
                    arcanismo.setEnabled(true);
                    historia.setEnabled(true);
                    intuicao.setEnabled(true);
                    investigacao.setEnabled(true);
                    medicina.setEnabled(true);
                    religiao.setEnabled(true);
                }
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
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    //spinner background
        List<String> background =  new ArrayList<String>();
        background.add("Acólito");
        background.add("Criminoso");
        background.add("Herói popular");
        background.add("Sábio");
        background.add("Soldado");

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, background);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems3 = (Spinner) findViewById(R.id.spnBackground);
        sItems3.setAdapter(adapter3);
        String selected3 = sItems3.getSelectedItem().toString();

        sItems3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getSelectedItem().equals("Acólito")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    intuicao.setEnabled(false);
                    intuicao.setChecked(true);
                    religiao.setEnabled(false);
                    religiao.setChecked(true);
                }
                else if (adapterView.getSelectedItem().equals("Criminoso")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    enganacao.setEnabled(false);
                    enganacao.setChecked(true);
                    furtividade.setEnabled(false);
                    furtividade.setChecked(true);
                }
                else if (adapterView.getSelectedItem().equals("Herói popular")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    adestraranimais.setEnabled(false);
                    adestraranimais.setChecked(true);
                    sobrevivencia.setEnabled(false);
                    sobrevivencia.setChecked(true);
                }
                else if (adapterView.getSelectedItem().equals("Sábio")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    arcanismo.setEnabled(false);
                    arcanismo.setChecked(true);
                    historia.setEnabled(false);
                    historia.setChecked(true);
                }
                else if (adapterView.getSelectedItem().equals("Soldado")){
                    Toast.makeText(AddPersonagem.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    atletismo.setEnabled(false);
                    atletismo.setChecked(true);
                    intimidacao.setEnabled(false);
                    intimidacao.setChecked(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button salvar = findViewById(R.id.salvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddPersonagem.this, "Personagem Salvo", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void resetaBotoes(){
        //desliga todos as checkboxes

        //forca
        final CheckBox atletismo = findViewById(R.id.atletismo);
        atletismo.setEnabled(false);
        atletismo.setChecked(false);

        //destreza
        final CheckBox acrobacia = findViewById(R.id.acrobacia);
        acrobacia.setEnabled(false);
        acrobacia.setChecked(false);
        final CheckBox furtividade = findViewById(R.id.furtividade);
        furtividade.setEnabled(false);
        furtividade.setChecked(false);
        final CheckBox prestigitacao = findViewById(R.id.prestigitacao);
        prestigitacao.setEnabled(false);
        prestigitacao.setChecked(false);

        //inteligencia
        final CheckBox arcanismo = findViewById(R.id.arcanismo);
        arcanismo.setEnabled(false);
        arcanismo.setChecked(false);
        final CheckBox historia = findViewById(R.id.historia);
        historia.setEnabled(false);
        historia.setChecked(false);
        final CheckBox investigacao = findViewById(R.id.investigacao);
        investigacao.setEnabled(false);
        investigacao.setChecked(false);
        final CheckBox natureza = findViewById(R.id.natureza);
        natureza.setEnabled(false);
        natureza.setChecked(false);
        final CheckBox religiao = findViewById(R.id.religiao);
        religiao.setEnabled(false);
        religiao.setChecked(false);

        //sabedoria
        final CheckBox adestraranimais = findViewById(R.id.adestraranimais);
        adestraranimais.setEnabled(false);
        adestraranimais.setChecked(false);
        final CheckBox intuicao = findViewById(R.id.intuicao);
        intuicao.setEnabled(false);
        intuicao.setChecked(false);
        final CheckBox medicina = findViewById(R.id.medicina);
        medicina.setEnabled(false);
        medicina.setChecked(false);
        final CheckBox percepcao = findViewById(R.id.percepcao);
        percepcao.setEnabled(false);
        percepcao.setChecked(false);
        final CheckBox sobrevivencia = findViewById(R.id.sobrevivencia);
        sobrevivencia.setEnabled(false);
        sobrevivencia.setChecked(false);

        //carisma
        final CheckBox atuacao = findViewById(R.id.atuacao);
        atuacao.setEnabled(false);
        atuacao.setChecked(false);
        final CheckBox enganacao = findViewById(R.id.enganacao);
        enganacao.setEnabled(false);
        enganacao.setChecked(false);
        final CheckBox intimidacao = findViewById(R.id.intimidacao);
        intimidacao.setEnabled(false);
        intimidacao.setChecked(false);
        final CheckBox persuasao = findViewById(R.id.persuasao);
        persuasao.setEnabled(false);
        persuasao.setChecked(false);
    }
}
