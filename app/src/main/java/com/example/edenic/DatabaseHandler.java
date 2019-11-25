package com.example.edenic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context){super(context,"Edenic",null,1);}
    //database version
    private static final int DATABASE_VERSION = 1;

    //database name
    private static final String DATABASE_SPELL = "feiticos.db";
    private static final String DATABASE_CHAR = "personagens.db";
    private static final String DATABASE_PROF = "proficiencia.db";

    //Table name
    private static final String TABLE_SPELLS = "feiticos";
    private static final String TABLE_CHAR = "personagens";
    private static final String TABLE_PROF = "proficiencias";

    //table feiticos fields
    private static final String SPELL_ID = "id";
    private static final String SPELL_NAME = "name";
    private static final String SPELL_NIVEL = "nivel";
    private static final String SPELL_CAST_TIME = "castTime";
    private static final String SPELL_RANGE = "range";
    private static final String SPELL_DURATION = "duration";
    private static final String SPELL_CLASSE = "classe";
    private static final String SPELL_DESC = "descricao";

    //table personagens fields
    private static final String CHAR_ID = "char_id";
    private static final String CHAR_NAME = "char_nome";
    private static final String CHAR_NIVEL = "char_nivel";
    private static final String CHAR_RACA = "char_raca";
    private static final String CHAR_CLASS = "char_class";
    private static final String CHAR_BACK = "char_back";
    private static final String CHAR_STR = "char_str";
    private static final String CHAR_DEX = "char_dex";
    private static final String CHAR_CONS = "char_cons";
    private static final String CHAR_INT = "char_int";
    private static final String CHAR_WIS = "char_wis";
    private static final String CHAR_CHAR = "char_char";
    private static final String CHAR_HP = "char_hp";
    private static final String CHAR_DESC = "char_desc";

    //table personagens fields
    private static final String PROF_ID = "prof_id";
    private static final String PROF_ATL = "prof_atl";
    private static final String PROF_ACR = "prof_acr";
    private static final String PROF_FURT = "prof_furt";
    private static final String PROF_PREST = "prof_prest";
    private static final String PROF_ARC = "prof_arc";
    private static final String PROF_HIS = "prof_his";
    private static final String PROF_INVES = "prof_inves";
    private static final String PROF_NATU = "prof_natu";
    private static final String PROF_RELI = "prof_reli";
    private static final String PROF_ADES = "prof_ades";
    private static final String PROF_INTUI = "prof_intui";
    private static final String PROF_MEDIC = "prof_medic";
    private static final String PROF_PERCEP = "prof_percep";
    private static final String PROF_SOBRE = "prof_sobre";
    private static final String PROF_ATUA = "prof_atua";
    private static final String PROF_ENGANA = "prof_engana";
    private static final String PROF_INTI = "prof_inti";
    private static final String PROF_PERSU = "prof_persu";

@Override
    public void onCreate(SQLiteDatabase db) {
        //banco feiticos
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_SPELLS+ "( "
                +SPELL_ID + " "+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +SPELL_NAME+ " VARCHAR(255) NOT NULL,"
                +SPELL_NIVEL+ " int(2) NOT NULL, "
                +SPELL_CAST_TIME+ " varchar(255) DEFAULT NULL, "
                +SPELL_RANGE+ " VARCHAR(255) DEFAULT NULL, "
                +SPELL_DURATION+ " VARCHAR(255) DEFAULT NULL, "
                +SPELL_CLASSE+ " VARCHAR(255) NOT NULL, "
                +SPELL_DESC+ " VARCHAR(255) NOT NULL "
                + ")");



        //banco Personagens
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_CHAR+ " ( "
                +CHAR_ID + " "+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +CHAR_NAME+ " VARCHAR(255) NOT NULL,"
                +CHAR_NIVEL+ " int(2) NOT NULL, "
                +CHAR_RACA+ " VARCHAR(255) NOT NULL, "
                +CHAR_CLASS+ " VARCHAR(255) NOT NULL, "
                +CHAR_BACK+ " VARCHAR(255) NOT NULL, "
                +CHAR_STR+ " int(2) NOT NULL, "
                +CHAR_DEX+ " int(2) NOT NULL, "
                +CHAR_CONS+ " int(2) NOT NULL, "
                +CHAR_INT+ " int2(2) NOT NULL, "
                +CHAR_WIS+ " int(2) NOT NULL, "
                +CHAR_CHAR+ " int(2) NOT NULL, "
                +CHAR_HP+ " int(2) NOT NULL, "
                +CHAR_DESC+ " VARCHAR(255) DEFAULT NULL"
                + ")");
    
    
    
        //banco Personagens
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_PROF+ " ( "
                +PROF_ID + " "+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PROF_ATL+ " int(3) NOT NULL,"
                +PROF_ACR+ " int(3) NOT NULL,"
                +PROF_FURT+ " int(3) NOT NULL,"
                +PROF_PREST+ " int(3) NOT NULL,"
                +PROF_ARC+ " int(3) NOT NULL,"
                +PROF_HIS+ " int(3) NOT NULL,"
                +PROF_INVES+ " int(3) NOT NULL,"
                +PROF_NATU+ " int(3) NOT NULL,"
                +PROF_RELI+ " int(3) NOT NULL,"
                +PROF_ADES+ " int(3) NOT NULL,"
                +PROF_INTUI+ " int(3) NOT NULL,"
                +PROF_MEDIC+ " int(3) NOT NULL,"
                +PROF_PERCEP+ " int(3) NOT NULL,"
                +PROF_SOBRE+ " int(3) NOT NULL,"
                +PROF_ATUA+ " int(3) NOT NULL,"
                +PROF_ENGANA+ " int(3) NOT NULL,"
                +PROF_INTI+ " int(3) NOT NULL,"
                +PROF_PERSU+ " int(3) NOT NULL"
                + ")");
                    //                                                                                  Nome,nivel,cast time, range, duracao, classe, descrição
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Consertar',0,'1 minuto', 'Toque','instantaneo','Clérigo',' Essa magia repara um única quebra ou fissura em um objeto que você tocar, como um elo quebrado de uma corrente, duas metades de uma chave partida, um manto rasgado ou o vazamento em um odre. Contanto que a quebra ou fissura não tenha mais de 30 centímetros em qualquer dimensão, você pode remenda-la, não deixando qualquer vestígio do dano anterior. Essa magia pode reparar fisicamente um item mágico ou constructo, mas a magia não irá restaurar a magia em tais objetos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Orientação',0,'1 ação', 'Toque','até 1 minuto','Clérigo','Você toca uma criatura voluntária. Uma vez, antes da magia acabar, o alvo pode rolar um d4 e adicionar o número rolado a um teste de habilidade a escolha dele. Ele pode rolar o dado antes ou depois de realizar o teste de habilidade. Após isso, a magia termina.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Palavra curativa',1,'1 ação bonus','18 metros','instantaneo','Clérigo','Uma criatura, à sua escolha, que você possa ver dentro do alcance recupera uma quantidade de pontos de vida igual a 1d4 + seu modificador de habilidade de conjuração. Essa magia não tem efeito em mortos-vivos ou constructosEm Níveis Superiores. Quando você conjurar essa magia usando um espaço de magia de 2° nível ou superior, a cura aumenta em 1d4 para cada nível do espaço acima do 1°')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Resistência',0,'1 ação','Toque','até 1 minuto','Clérigo','Você toca uma criatura voluntária. Uma vez, antes da magia acabar, o alvo pode rolar um d4 e adicionar o valor jogado a um teste de resistência de sua escolha. Ele pode rolar o dado antes ou depois de realizar o teste de resistência. Então, a magia termina.')");
        db.execSQL("INSERT INTO  feiticos (name, nivel,castTime,range,duration,classe,descricao) VALUES ('Luz',0,'1 ação','toque','1 hora', 'Clérigo', 'Você toca um objeto que não tenha mais 3 metros em qualquer dimensão. Até a magia acabar, o objeto emite luz plena num raio de 6 metros e penumbra por 6 metros adicionais. Cobrir o objeto completamente com alguma coisa opaca bloqueará a luz. A magia termina se você conjura-la novamente ou dissipa-la com uma ação.Se você tentar afetar um objeto segurado ou vestido por uma criatura hostil, a criatura deve ser bem sucedida num teste de Destreza para evitar a magia.')");
        db.execSQL("INSERT INTO personagens (char_nome, char_nivel, char_raca, char_class, char_back, char_str, char_dex,char_cons, char_int,char_wis,char_char,char_hp,char_desc) VALUES ('Personagem',1, 'Anão', 'Guerreiro', 'Bandido', 1, 2, 3, 4, 5, 6, 7, 'desc')");
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELLS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAR);
//        onCreate(db);
    }
}
