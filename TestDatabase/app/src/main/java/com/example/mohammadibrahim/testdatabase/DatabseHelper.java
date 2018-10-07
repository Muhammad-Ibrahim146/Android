package com.example.mohammadibrahim.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mohammad Ibrahim on 29-Aug-18.
 */

public class DatabseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my.db";
    private static final String TABLE_NAME="contacts";
    private static int DATABASE_VERSION = 1;


    public DatabseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");

     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertdata(String name,int mobile_numbre,String email){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("MOBILE_NUMBER",mobile_numbre);
        contentValues.put("EMAIL",email);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;


    }
     public Cursor getData(String mobile_numbre)
     {

         SQLiteDatabase db=this.getWritableDatabase();

         String quary ="SELECT * FROM "+ TABLE_NAME +" WHERE MOBILE_NUMBER = '"+ mobile_numbre + "'";

         Cursor cursor=db.rawQuery(quary,null);

         return cursor;


     }
    public void deleteData(String mobile_numbre)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME," MOBILE_NUMBER = '"+ mobile_numbre + "'" ,null);
        db.close();
    }

    public void updateData(String number , String name ,String mail)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("EMAIL" , mail);
        contentValues.put(" MOBILE_NUMBER",number);

        db.update(TABLE_NAME,contentValues,"MOBILE_NUMBER = '"+ number + "'",null);
        db.close();

    }
}
