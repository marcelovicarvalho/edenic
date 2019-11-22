package com.example.edenic;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class AddPersonagem extends AppCompatActivity {
    
    int HP = 0;
    String classe, raca, background;
    
    ArrayList<Integer> checkForca = new ArrayList<>();
    ArrayList<Integer> checkDestreza = new ArrayList<>();
    ArrayList<Integer> checkInteligencia = new ArrayList<>();
    ArrayList<Integer> checkSabedoria = new ArrayList<>();
    ArrayList<Integer> checkCarisma = new ArrayList<>();

    int forca2 = 0;
    int destreza2 = 0;
    int constituicao2 = 0;
    int inteligencia2 = 0;
    int sabedoria2 = 0;
    int carisma2 = 0;

    int atletismo2 = 0;
    int acrobacia2 = 0;
    int furtividade2 = 0;
    int prestigitacao2 = 0;
    int arcanismo2 = 0;
    int historia2 = 0;
    int investigacao2 = 0;
    int natureza2 = 0;
    int religiao2 = 0;
    int adestraranimais2 = 0;
    int intuicao2 = 0;
    int medicina2 = 0;
    int percepcao2 = 0;
    int sobrevivencia2 = 0;
    int atuacao2 = 0;
    int enganacao2 = 0;
    int intimidacao2 = 0;
    int persuasao2 = 0;

    int somaStatus = 0;
    
    
    
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
        NumberPicker constituicao = (NumberPicker) findViewById(R.id.constituicao);
        NumberPicker inteligencia = (NumberPicker) findViewById(R.id.inteligencia);
        NumberPicker sabedoria = (NumberPicker) findViewById(R.id.sabedoria);
        NumberPicker carisma = (NumberPicker) findViewById(R.id.carisma);
        
        String[] nums = new String[20];
        for(int i=0; i<nums.length; i++)
            nums[i] = Integer.toString(i+1);

    //forca
        forca.setMinValue(1);
        forca.setMaxValue(20);
        forca.setWrapSelectorWheel(false);
        forca.setDisplayedValues(nums);
        forca.setValue(8);

    //destreza
        destreza.setMinValue(1);
        destreza.setMaxValue(20);
        destreza.setWrapSelectorWheel(false);
        destreza.setDisplayedValues(nums);
        destreza.setValue(8);
        
    //constituicao
        constituicao.setMinValue(1);
        constituicao.setMaxValue(20);
        constituicao.setWrapSelectorWheel(false);
        constituicao.setDisplayedValues(nums);
        constituicao.setValue(8);
        
    //inteligencia
        inteligencia.setMinValue(1);
        inteligencia.setMaxValue(20);
        inteligencia.setWrapSelectorWheel(false);
        inteligencia.setDisplayedValues(nums);
        inteligencia.setValue(8);

    //sabedoria
        sabedoria.setMinValue(1);
        sabedoria.setMaxValue(20);
        sabedoria.setWrapSelectorWheel(false);
        sabedoria.setDisplayedValues(nums);
        sabedoria.setValue(8);

    //carisma
        carisma.setMinValue(1);
        carisma.setMaxValue(20);
        carisma.setWrapSelectorWheel(false);
        carisma.setDisplayedValues(nums);
        carisma.setValue(8);

    //spinner classe
        List<String> classes =  new ArrayList<String>();
        classes.add("Classe");
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
                    HP = HP + 10;
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
                    HP = HP + 8;
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
                    HP = HP + 6;
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
        racas.add("Raça");
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
        background.add("Antecessor");
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
                
                //Pega o valor do spinner para enviar pro db local
                String nome = ((EditText) findViewById(R.id.nomepersonagem)).getText().toString();
                String classe = ((Spinner) findViewById(R.id.spnClasse)).getSelectedItem().toString();
                String raca = ((Spinner) findViewById(R.id.spnRaca)).getSelectedItem().toString();
                String background = ((Spinner) findViewById(R.id.spnBackground)).getSelectedItem().toString();
                
                //Pega o valor do number picker
                int forca = ((NumberPicker) findViewById(R.id.forca)).getValue();
                int destreza = ((NumberPicker) findViewById(R.id.destreza)).getValue();
                int constituicao = ((NumberPicker) findViewById(R.id.constituicao)).getValue();
                int inteligencia = ((NumberPicker) findViewById(R.id.inteligencia)).getValue();
                int sabedoria = ((NumberPicker) findViewById(R.id.sabedoria)).getValue();
                int carisma = ((NumberPicker) findViewById(R.id.carisma)).getValue();
                
                //
                
                switch (raca){
                    case "Anão":
                        constituicao = constituicao + 2;
                        
                        forca2 = forca;
                        destreza2 = destreza;
                        constituicao2 = modificadorStatus(constituicao);
                        inteligencia2 = inteligencia;
                        sabedoria2 = sabedoria;
                        carisma2 = carisma;
    
                        modificadorStatus(forca);
                        atletismo2 = somaStatus;
    
                        destreza2 = modificadorStatus(destreza);
                        acrobacia2 = somaStatus;
                        furtividade2 = somaStatus;
                        prestigitacao2 = somaStatus;
    
                        constituicao2 = modificadorStatus(constituicao);
                        HP = HP + somaStatus;
    
                        inteligencia2 = modificadorStatus(inteligencia);
                        arcanismo2 = somaStatus;
                        historia2 = somaStatus;
                        investigacao2 = somaStatus;
                        natureza2 = somaStatus;
                        religiao2 = somaStatus;
    
                        sabedoria2 = modificadorStatus(sabedoria);
                        adestraranimais2 = somaStatus;
                        intuicao2 = somaStatus;
                        medicina2 = somaStatus;
                        percepcao2 = somaStatus;
                        sobrevivencia2 = somaStatus;
    
                        carisma2 = modificadorStatus(carisma);
                        atuacao2 = somaStatus;
                        enganacao2 = somaStatus;
                        intimidacao2 = somaStatus;
                        persuasao2 = somaStatus;
                        
                        break;
                        
                    case "Elfo":
                        destreza = destreza + 2;
                        
                        forca2 = forca;
                        destreza2 = modificadorStatus(destreza);
                        constituicao2 = constituicao;
                        inteligencia2 = inteligencia;
                        sabedoria2 = sabedoria;
                        carisma2 = sabedoria;
    
                        modificadorStatus(forca);
                        atletismo2 = somaStatus;
    
                        destreza2 = modificadorStatus(destreza);
                        acrobacia2 = somaStatus;
                        furtividade2 = somaStatus;
                        prestigitacao2 = somaStatus;
    
                        constituicao2 = modificadorStatus(constituicao);
                        HP = HP + somaStatus;
    
                        inteligencia2 = modificadorStatus(inteligencia);
                        arcanismo2 = somaStatus;
                        historia2 = somaStatus;
                        investigacao2 = somaStatus;
                        natureza2 = somaStatus;
                        religiao2 = somaStatus;
    
                        sabedoria2 = modificadorStatus(sabedoria);
                        adestraranimais2 = somaStatus;
                        intuicao2 = somaStatus;
                        medicina2 = somaStatus;
                        percepcao2 = somaStatus;
                        sobrevivencia2 = somaStatus;
    
                        carisma2 = modificadorStatus(carisma);
                        atuacao2 = somaStatus;
                        enganacao2 = somaStatus;
                        intimidacao2 = somaStatus;
                        persuasao2 = somaStatus;
                        
                        break;
                        
                    case "Halfling":
                        destreza = destreza + 2;
                        
                        forca2 = forca;
                        destreza2 = modificadorStatus(destreza);
                        constituicao2 = constituicao;
                        inteligencia2 = inteligencia;
                        sabedoria2 = sabedoria;
                        carisma2 = sabedoria;
    
                        modificadorStatus(forca);
                        atletismo2 = somaStatus;
    
                        destreza2 = modificadorStatus(destreza);
                        acrobacia2 = somaStatus;
                        furtividade2 = somaStatus;
                        prestigitacao2 = somaStatus;
    
                        constituicao2 = modificadorStatus(constituicao);
                        HP = HP + somaStatus;
    
                        inteligencia2 = modificadorStatus(inteligencia);
                        arcanismo2 = somaStatus;
                        historia2 = somaStatus;
                        investigacao2 = somaStatus;
                        natureza2 = somaStatus;
                        religiao2 = somaStatus;
    
                        sabedoria2 = modificadorStatus(sabedoria);
                        adestraranimais2 = somaStatus;
                        intuicao2 = somaStatus;
                        medicina2 = somaStatus;
                        percepcao2 = somaStatus;
                        sobrevivencia2 = somaStatus;
    
                        carisma2 = modificadorStatus(carisma);
                        atuacao2 = somaStatus;
                        enganacao2 = somaStatus;
                        intimidacao2 = somaStatus;
                        persuasao2 = somaStatus;
                        
                        break;
                        
                    case "Humano":
    
                        forca = forca + 1;
                        destreza = destreza + 1;
                        constituicao = constituicao + 1;
                        inteligencia = inteligencia + 1;
                        sabedoria = sabedoria + 1;
                        carisma = carisma + 1;
                        
                        modificadorStatus(forca);
                        atletismo2 = somaStatus;
                        
                        destreza2 = modificadorStatus(destreza);
                        acrobacia2 = somaStatus;
                        furtividade2 = somaStatus;
                        prestigitacao2 = somaStatus;
                        
                        constituicao2 = modificadorStatus(constituicao);
                        HP = HP + somaStatus;
                        
                        inteligencia2 = modificadorStatus(inteligencia);
                        arcanismo2 = somaStatus;
                        historia2 = somaStatus;
                        investigacao2 = somaStatus;
                        natureza2 = somaStatus;
                        religiao2 = somaStatus;
                        
                        sabedoria2 = modificadorStatus(sabedoria);
                        adestraranimais2 = somaStatus;
                        intuicao2 = somaStatus;
                        medicina2 = somaStatus;
                        percepcao2 = somaStatus;
                        sobrevivencia2 = somaStatus;
                        
                        carisma2 = modificadorStatus(carisma);
                        atuacao2 = somaStatus;
                        enganacao2 = somaStatus;
                        intimidacao2 = somaStatus;
                        persuasao2 = somaStatus;
                        
                        break;
                }
                
                itemSelecionado();
                
                gravaBanco(getBaseContext()).rawQuery("INSERT INTO personagens (char_nome,char_nivel,char_raca,char_class,char_back,char_str,char_dex,char_cons,char_int,char_wis,char_char,char_hp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new String[]{nome,"1",raca,classe,background,String.valueOf(forca2),String.valueOf(destreza2),String.valueOf(constituicao2),String.valueOf(inteligencia2),String.valueOf(sabedoria2),String.valueOf(HP)});
                gravaBanco(getBaseContext()).rawQuery("INSERT INTO proficiencias (prof_atl,prof_acr,prof_furt,prof_prest,prof_arc,prof_his,prof_inves,prof_natu,prof_reli,prof_ades,prof_intui,prof_medic,prof_percep,prof_sobre,prof_atua,prof_engana,prof_inti,prof_persu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[]{String.valueOf(atletismo2),String.valueOf(acrobacia2),String.valueOf(furtividade2),String.valueOf(prestigitacao2),String.valueOf(arcanismo2),String.valueOf(historia2),String.valueOf(investigacao2),String.valueOf(natureza2),String.valueOf(religiao2),String.valueOf(adestraranimais2),String.valueOf(intuicao2),String.valueOf(medicina2),String.valueOf(percepcao2),String.valueOf(sobrevivencia2),String.valueOf(atuacao2),String.valueOf(enganacao2),String.valueOf(intimidacao2),String.valueOf(persuasao2)});
                
                Toast.makeText(AddPersonagem.this, "Personagem Salvo", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    
    private int calculaHP(int HP){
        int HP2 = 0;
        switch (classe){
            case "Clerigo":
                HP2 = 8 + constituicao2;
                break;
            case "Guerreiro":
                break;
            case "Ladino":
                break;
            case "Mago":
                break;
        }
        return HP2;
    }
    
    private int modificadorStatus(int status){
        int status2 = 0;
        if(status == 1){
            status2 = status - 5;
            somaStatus = -5;
        }
        else if(status == 2 || status == 3){
            status2 = status - 4;
            somaStatus = -4;
        }
        else if(status == 4 || status == 5){
            status2 = status - 3;
            somaStatus = -3;
        }
        else if(status == 6 || status == 7){
            status2 = status - 2;
            somaStatus = -2;
        }
        else if(status == 8 || status == 9){
            status2 = status - 1;
            somaStatus = -1;
        }
        else if(status == 10 || status == 11){
            status2 = status;
            somaStatus = 0;
        }
        else if(status == 12 || status == 13){
            status2 = status + 1;
            somaStatus = 1;
        }
        else if(status == 14 || status == 15){
            status2 = status + 2;
            somaStatus = 2;
        }
        else if(status == 16 || status == 17){
            status2 = status + 3;
            somaStatus = 3;
        }
        else if(status == 18 || status == 19){
            status2 = status + 4;
            somaStatus = 4;
        }
        else if(status == 20){
            status2 = status + 5;
            somaStatus = 5;
        }
        return status2;
    }
    
    private void itemSelecionado(){
        final CheckBox atletismo = findViewById(R.id.atletismo);
    
        final CheckBox acrobacia = findViewById(R.id.acrobacia);
        final CheckBox furtividade = findViewById(R.id.furtividade);
        final CheckBox prestigitacao = findViewById(R.id.prestigitacao);
    
        final CheckBox arcanismo = findViewById(R.id.arcanismo);
        final CheckBox historia = findViewById(R.id.historia);
        final CheckBox investigacao = findViewById(R.id.investigacao);
        final CheckBox natureza = findViewById(R.id.natureza);
        final CheckBox religiao = findViewById(R.id.religiao);
    
        final CheckBox adestraranimais = findViewById(R.id.adestraranimais);
        final CheckBox intuicao = findViewById(R.id.intuicao);
        final CheckBox medicina = findViewById(R.id.medicina);
        final CheckBox percepcao = findViewById(R.id.percepcao);
        final CheckBox sobrevivencia = findViewById(R.id.sobrevivencia);
    
        final CheckBox atuacao = findViewById(R.id.atuacao);
        final CheckBox enganacao = findViewById(R.id.enganacao);
        final CheckBox intimidacao = findViewById(R.id.intimidacao);
        final CheckBox persuasao = findViewById(R.id.persuasao);
        
        // NAO ESTA PASSANDO O VALOR CORRETO PELA (retonarModStatus)
        
        //forca
        if (atletismo.isChecked()){
            atletismo2 = 2 + atletismo2;
        }
        
        //destreza
        if (acrobacia.isChecked()){
            acrobacia2 = 2 + acrobacia2;
        }
        if (furtividade.isChecked()){
            furtividade2 = 2 + furtividade2;
        }
        if (prestigitacao.isChecked()){
            prestigitacao2 = 2 + prestigitacao2;
        }
        //inteligencia
        if (arcanismo.isChecked()){
            arcanismo2 = 2 + arcanismo2;
        }
        if (historia.isChecked()){
            historia2 = 2 + historia2;
        }
        if (investigacao.isChecked()){
            investigacao2 = 2 + investigacao2;
        }
        if (natureza.isChecked()){
            natureza2 = 2 + natureza2;
        }
        if (religiao.isChecked()){
            religiao2 = 2 + religiao2;
        }
        
        //sabedoria
        if (adestraranimais.isChecked()){
            adestraranimais2 = 2 + adestraranimais2;
        }
        if (intuicao.isChecked()){
            intuicao2 = 2 + intuicao2;
        }
        if (medicina.isChecked()){
            medicina2 = 2 + medicina2;
        }
        if (percepcao.isChecked()){
            percepcao2 = 2 + percepcao2;
        }
        if (sobrevivencia.isChecked()){
            sobrevivencia2 = 2 + sobrevivencia2;
        }
        
        //carisma
        if (atuacao.isChecked()){
            atuacao2 = 2 + atuacao2;
        }
        if (enganacao.isChecked()){
            enganacao2 = 2 + enganacao2;
        }
        if (intimidacao.isChecked()){
            intimidacao2 = 2 + intimidacao2;
        }
        if (persuasao.isChecked()){
            persuasao2 = 2 + persuasao2;
        }
    }
    
    private SQLiteDatabase gravaBanco(Context context){
        DatabaseHandler banco = new DatabaseHandler(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        return db;
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
