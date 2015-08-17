package com.example.captaofmyp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UsuariosDataSource {
	
	private SQLiteDatabase database;
	  private MyPSqlite1 dbHelper;
	  private String[] allColumns = { MyPSqlite1.COLUMN_CODVENDEDOR, MyPSqlite1.COLUMN_USUARIO,
	  MyPSqlite1.COLUMN_PASSWORD };
	  public UsuariosDataSource(Context context) {
	    dbHelper = new MyPSqlite1(context);
	  }

	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  /*public Usuarios createUsuarios(String Usuarios) {
	    ContentValues values = new ContentValues();
	    values.put(MyPSqlite1.COLUMN_USUARIO, Usuarios);
	    long insertId = database.insert(MyPSqlite1.COLUMN_CODVENDEDOR, null,
	        values);
	    Cursor cursor = database.query(MyPSqlite1.COLUMN_USUARIO,
	        allColumns, MyPSqlite1.COLUMN_CODVENDEDOR + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Usuarios newUsuarios = cursorToUsuarios(cursor);
	    cursor.close();
	    return newUsuarios;
	  }*/

	  /*public void deleteUsuarios(Usuarios Usuarios) {
	    long id = Usuarios.getCodvendedor();
	    System.out.println("Usuarios deleted with id: " + id);
	    database.delete(MyPSqlite1.TABLE_USUARIOS, MyPSqlite1.COLUMN_CODVENDEDOR
	        + " = " + id, null);
	  }*/

	  public List<Usuarios> getAllUsuarioss() {
	    List<Usuarios> Usuarioss = new ArrayList<Usuarios>();

	    Cursor cursor = database.query(MyPSqlite1.COLUMN_USUARIO,
	        allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      Usuarios Usuarios = cursorToUsuarios(cursor);
	      Usuarioss.add(Usuarios);
	      cursor.moveToNext();
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return Usuarioss;
	  }

	  private Usuarios cursorToUsuarios(Cursor cursor) {
	    Usuarios Usuarios = new Usuarios();
	    Usuarios.setId(cursor.getInt(0));
	    Usuarios.setUsuario(cursor.getString(1));
	    return Usuarios;
	  }

}
