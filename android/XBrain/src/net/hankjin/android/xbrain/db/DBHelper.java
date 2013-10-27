package net.hankjin.android.xbrain.db;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "xbrain.db"; 
    private static final int DATABASE_VERSION = 1;
    
    DBHelper(Context context) {  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }  
  
    @Override  
    public void onCreate(SQLiteDatabase db) {  
    	System.out.print("Database Created");
        db.execSQL(Book.tableCreate);  
        db.execSQL("insert into book(id, name) values(1,'Django Dev book')");
        db.execSQL("insert into book(id, name) values(2,'Android Dev Guide')");
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}  
	private static DBHelper staticDB = null;
	
	public static void initDB(Activity activity){
		staticDB = new DBHelper(activity);
	}
	public static DBHelper getDB(){
		return staticDB;
	}
}
