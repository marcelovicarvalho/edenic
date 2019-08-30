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

    //Table name
    private static final String TABLE_SPELLS = "feiticos";
    private static final String TABLE_CHAR = "personagens";

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
                +CHAR_BACK+ " VARCHAR(255) DEFAULT NULL, "
                +CHAR_STR+ " int(2) NOT NULL, "
                +CHAR_DEX+ " int(2) NOT NULL, "
                +CHAR_CONS+ " int(2) NOT NULL, "
                +CHAR_INT+ " int2(2) NOT NULL, "
                +CHAR_WIS+ " int(2) NOT NULL, "
                +CHAR_CHAR+ " VARCHAR(255) DEFAULT NULL, "
                +CHAR_HP+ " VARCHAR(2) NOT NULL "
                + ")");

        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Enraizar',1,'instantanio', '90 feet','ate 1 minuto','druida','DESCRICAO')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELLS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAR);
//        onCreate(db);
    }
}
