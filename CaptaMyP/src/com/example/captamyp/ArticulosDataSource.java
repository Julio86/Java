package com.example.captamyp;

import java.util.ArrayList;
import java.util.List;

import com.example.captamyp.Articulos;
import com.example.captamyp.MyPSqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class ArticulosDataSource {
	 private SQLiteDatabase database;
	  private MyPSqlite dbHelper;
	  private String[] allColumns = { MyPSqlite.COLUMN_ID, MyPSqlite.COLUMN_ARTICULOS,
	  MyPSqlite.COLUMN_BULTOS, MyPSqlite.COLUMN_UNIDADES,
	  MyPSqlite.COLUMN_SERIE, MyPSqlite.COLUMN_NUMERO, MyPSqlite.COLUMN_ETIQUETAS };
	  public ArticulosDataSource(Context context) {
	    dbHelper = new MyPSqlite(context);
	  }

	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  public Articulos createArticulos(String Articulos) {
	    ContentValues values = new ContentValues();
	    values.put(MyPSqlite.COLUMN_ARTICULOS, Articulos);
	    long insertId = database.insert(MyPSqlite.TABLE_ARTICULOS, null,
	        values);
	    Cursor cursor = database.query(MyPSqlite.COLUMN_ARTICULOS,
	        allColumns, MyPSqlite.COLUMN_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Articulos newArticulos = cursorToArticulos(cursor);
	    cursor.close();
	    return newArticulos;
	  }

	  public void deleteArticulos(Articulos Articulos) {
	    long id = Articulos.getId();
	    System.out.println("Articulos deleted with id: " + id);
	    database.delete(MyPSqlite.TABLE_ARTICULOS, MyPSqlite.COLUMN_ID
	        + " = " + id, null);
	  }

	  public List<Articulos> getAllArticuloss() {
	    List<Articulos> Articuloss = new ArrayList<Articulos>();

	    Cursor cursor = database.query(MyPSqlite.TABLE_ARTICULOS,
	        allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      Articulos Articulos = cursorToArticulos(cursor);
	      Articuloss.add(Articulos);
	      cursor.moveToNext();
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return Articuloss;
	  }

	  private Articulos cursorToArticulos(Cursor cursor) {
	    Articulos Articulos = new Articulos();
	    Articulos.setId(cursor.getLong(0));
	    Articulos.setArticulos(cursor.getString(1));
	    return Articulos;
	  }

}
