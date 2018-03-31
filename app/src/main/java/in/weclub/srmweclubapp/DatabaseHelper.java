package in.weclub.srmweclubapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    private static final String COLUMN_FNAME = "FirstName";
    private static final String COLUMN_LNAME = "LastName";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MOBNO = "mobNo" ;
    private static final String COLUMN_PASS = "pass";

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null  , "+
            "fname text not null , lname text not null, email text not null, mobNo text not null , pass text not null);" ;


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+" (id TEXT PRIMARY KEY, FirstName TEXT NOT NULL, LastName TEXT NOT NULL, email TEXT NOT NULL, mobNo TEXT NOT NULL, pass TEXT NOT NULL)");
       //this.db =db;
    }

    public boolean insertContact(String id, String fName, String LName, String email, String MobNo, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        db.beginTransaction();
        try{
        cv.put(COLUMN_ID, id); cv.put(COLUMN_FNAME, fName); cv.put(COLUMN_LNAME, LName);
        cv.put(COLUMN_EMAIL, email); cv.put(COLUMN_MOBNO, MobNo); cv.put(COLUMN_PASS, pass);
        db.insert(TABLE_NAME, null, cv);
        db.setTransactionSuccessful();}
        catch (Exception e){
            Log.e("Error in transaction",e.toString());
        return false;}
        finally {
            db.endTransaction();
            return true;
        }
        //long res = db.insert(TABLE_NAME, null, cv);
        //return res!=-1;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String query = " DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }

    public Cursor getLogin()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select "+ COLUMN_MOBNO + " , " + COLUMN_PASS + " from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getProile()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select *" +  " from " + TABLE_NAME, null);
        return res;
    }
}
