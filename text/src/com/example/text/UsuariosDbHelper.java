package com.example.text;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyP.db";
    public static final int DATABASE_VERSION = 1;

    public UsuariosDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Usuarios
        db.execSQL(UsuariosDataSource.CREATE_TABLE_USUARIOS);
        //Insertar registros iniciales
        db.execSQL(UsuariosDataSource.INSERT_TABLE_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Añade los cambios que se realizarán en el esquema
    }
}