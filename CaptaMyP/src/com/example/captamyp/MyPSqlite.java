package com.example.captamyp;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyPSqlite extends SQLiteOpenHelper {
	
	public static final String TABLE_ARTICULOS = "articulos";
	
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_ARTICULOS = "articulos";
	  public static final String COLUMN_BULTOS = "bultos";
	  public static final String COLUMN_UNIDADES = "unidades";
	  public static final String COLUMN_SERIE = "serie";
	  public static final String COLUMN_NUMERO = "numero";
	  public static final String COLUMN_ETIQUETAS = "etiquetas";
	  public static final String COLUMN_CODVENDEDOR = "codvendedor";
	  public static final String COLUMN_CODART = "codart";
	 
	  
	  private static final String DATABASE_NAME = "MyP.db";
	  private static final int DATABASE_VERSION = 1;

	  // Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_ARTICULOS + "(" + COLUMN_ID
	      + " integer primary key autoincrement, " + COLUMN_ARTICULOS
	      + " text not null," + COLUMN_BULTOS + "interger," +  COLUMN_CODART + "integer," + COLUMN_UNIDADES + "interger," + COLUMN_SERIE + 
	      "text," + COLUMN_NUMERO + "interger," + COLUMN_ETIQUETAS + "text," + ");";

	  
	  public MyPSqlite(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	  }


	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(MyPSqlite.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICULOS);
	    onCreate(db);
	  }
  
}
