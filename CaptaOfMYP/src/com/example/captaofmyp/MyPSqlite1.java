package com.example.captaofmyp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyPSqlite1 extends SQLiteOpenHelper {

	public static final String TABLE_USUARIOS = "usuarios";
	  public static final String COLUMN_USUARIO = "usuario";
	  public static final String COLUMN_PASSWORD = "password";
	  public static final String COLUMN_CODVENDEDOR = "codvendedor";
	  private static final String DATABASE_NAME = "MyP.db";
	  private static final int DATABASE_VERSION = 1;
	  
	  private static final String DATABASE_CREATE1 = "create table "
		      + TABLE_USUARIOS + "(" + COLUMN_CODVENDEDOR
		      + " integer primary key autoincrement, " + COLUMN_USUARIO
		      + " text not null," + COLUMN_PASSWORD + ");";
	  
	  public MyPSqlite1(Context context) {
		    super(context, DATABASE_NAME, null, DATABASE_VERSION);
		  }
	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE1);
	  }


	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(MyPSqlite.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
	    onCreate(db);
	  }

	  
}
