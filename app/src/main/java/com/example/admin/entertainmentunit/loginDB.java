package com.example.admin.entertainmentunit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class loginDB extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String login_list_TABLE_NAME = "login";
    public static final String login_list_COLUMN_NAME = "name";
    public static final String login_list_COLUMN_password = "password";
    public static final String login_list_COLUMN_address = "address";
    public static final String login_list_COLUMN_number = "number";
    public static final String login_list_COLUMN_email = "email";
    static int i = 0;

    public static final String login_list_ID = "id";
    private HashMap hp;
    public loginDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table login " +
                        "(id integer primary key, name text ,password text, address text, number text, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS login");
        onCreate(db);
    }
    // yeh auto dalna chiaye
    public boolean insertContact (String name, String password,String address, String number ,String email, int orderno) {
        SQLiteDatabase db = this.getWritableDatabase();

//        db.execSQL(
//                "create table login " +
//                        "(id integer primary key, name text ,password text, address text, number text, email text, orderno integar)");

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("number", number);
        contentValues.put("email", email);

        db.insert("login", null, contentValues);
        return true;
    }
    public boolean updateContact (String name, String password,String address, String number ,String email, int orderno,int x) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("number", number);
        contentValues.put("email", email);
        db.update("login",contentValues,"id = "+x,null);
        //db.insert("login", null, contentValues);
        return true;
    }
    public Cursor getData(String a, String b) {


        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL(
//                "create table login " +
//                        "(id integer primary key, name text ,password text, address text, number text, email text, orderno integar)");
        Cursor res =  db.rawQuery( "select * from login where name like '%"+a+"%'", null );
        System.out.println("Curson Count in dbhelper = "+res.getCount());
        return res;
    }
    public Cursor getview(int a) {

        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("get view"+a);
        Cursor res =  db.rawQuery( "select name,password,address,number,email from login where id = "+a, null );
        System.out.println("Curson Count in dbhelper = "+res.getCount());
        return res;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, login_list_TABLE_NAME);
        return numRows;
    }



}
