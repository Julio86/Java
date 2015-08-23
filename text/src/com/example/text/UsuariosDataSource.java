package com.example.text;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class UsuariosDataSource {

    //Metainformaci�n de la base de datos
    public static final String USUARIOS_TABLE_NAME = "Usuarios";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Usuarios
    public static class ColumnUsuarios{
        public static final String ID_ = BaseColumns._ID;
        public static final String COLUMN_USUARIO = "Usuario";
        public static final String COLUMN_PASS = "Contrase�a";
        public static final String COLUMN_CODVEND = "Codvend";
    }

    //Script de Creaci�n de la tabla Usuarios
    public static final String CREATE_TABLE_USUARIOS =
            "create table " + USUARIOS_TABLE_NAME + "(" +
                    ColumnUsuarios.ID_ + " " + INT_TYPE+" primary key autoincrement," +
                    ColumnUsuarios.COLUMN_USUARIO + " " + STRING_TYPE + " not null," +
                    ColumnUsuarios.COLUMN_PASS + " " + STRING_TYPE + " not null,"+
                    ColumnUsuarios.COLUMN_CODVEND + " " + STRING_TYPE + " not null)";

    //Scripts de inserci�n por defecto
    public static final String INSERT_TABLE_USUARIOS =
    		 "insert into "+USUARIOS_TABLE_NAME+" values(" +
                     "null," +
                     "\"Manuel\"," +
                     "\"1234\"," +
                     "\"1\"),"+
                     "(null," +
                     "\"Luis\"," +
                     "\"1234\"," +
                     "\"2\"),"+
                     "(null," +
                     "\"Macarena\"," +
                     "\"1234\"," +
                     "\"3\"),"+
                     "(null," +
                     "\"Adri\"," +
                     "\"1234\"," +
                     "\"4\"),"+
                     "(null," +
                     "\"Bermejo\"," +
                     "\"1234\"," +
                     "\"5\")";
    private UsuariosDbHelper openHelper;
    @SuppressWarnings("unused")
	private SQLiteDatabase database;

    public UsuariosDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new UsuariosDbHelper(context);
        database = openHelper.getWritableDatabase();
    }
}