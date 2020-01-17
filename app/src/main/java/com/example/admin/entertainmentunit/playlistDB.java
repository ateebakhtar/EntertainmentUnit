package com.example.admin.entertainmentunit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class playlistDB extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String show_list_TABLE_NAME = "playlist";
    public static final String show_list_COLUMN_name = "name";
    public static final String show_list_COLUMN_genre = "genre";
    public static final String show_list_COLUMN_catagory = "catagory";
    public static final String show_list_COLUMN_idx = "idx";
    public static final String show_list_COLUMN_url = "url";
    public static final String show_list_COLUMN_csid = "csid";
    public static final String show_list_ID = "id";

    private HashMap hp;

    public playlistDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(

                "create table playlist " +
                        "(id integer primary key, name text ,genre text, catagory text, idx integer, url text, csid integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS playlist");
        System.out.println("Data Entered");
        onCreate(db);
    }
    // yeh auto dalna chiaye
    public boolean insertlist (String name, String item1,String item2,int item3,String item4,int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("genre", item1);
        contentValues.put("catagory", item2);
        contentValues.put("idx", item3);
        contentValues.put("url", item4);
        MyApplication s = new MyApplication();
        id =  s.getSomeVariable();
        contentValues.put("csid", id);
        System.out.println(id);
        //insertshow("Castle","Drama","50 min","Andrew W Marlowe","8.2 IMDB","March 2009","173","No","http://cdn.breathecast.com/data/images/full/25015/castle-title-card.jpg");

        db.insert("playlist", null, contentValues);
        return true;
    }
    void deletetable(int x)
    {
        MyApplication s = new MyApplication();
        x =  s.getSomeVariable();
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("playlist","csid = " + x,null);

    }
    void deletedata(int id)
    {
        MyApplication s = new MyApplication();
        int csid =  s.getSomeVariable();
        System.out.println("playlist db "+csid);
        System.out.println("playlist item db "+id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("playlist","id = "+id+" and csid = "+csid,null);
    }
    public Cursor getData(String p,int a) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res;
        res = db.rawQuery("select * from playlist where name like '%"+p+"%' and csid = "+a,null);
        System.out.println("Curson in menudisplay after querry "+res.getCount());

        return res;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, show_list_TABLE_NAME);
        return numRows;
    }
    public ArrayList<String> getAllnames(int x) {


        ArrayList<String> array_list = new ArrayList<String>();
        MyApplication s = new MyApplication();
        x =  s.getSomeVariable();
        System.out.println("Data Entered atatg ");
        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL(
//
//                "create table playlist " +
//                        "(id integer primary key, name text ,genre text, catagory text, idx integer, url text, csid integer)");

        Cursor res =  db.rawQuery( "select * from playlist where csid = "+x, null );
        System.out.println(res.getCount());
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(show_list_COLUMN_name)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> getAllurl(int x) {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        MyApplication s = new MyApplication();
        x =  s.getSomeVariable();
        System.out.println("Data Entered get all url");
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from playlist where csid = "+x, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(show_list_COLUMN_url)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> getAllid(int x) {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        MyApplication s = new MyApplication();
        x =  s.getSomeVariable();
        System.out.println("Data Entered get all id");
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from playlist where csid = "+x, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(show_list_ID)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAll(int x) {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        MyApplication s = new MyApplication();
        x =  s.getSomeVariable();
        System.out.println("Data Entered get all id");
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from playlist where csid = "+x, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(show_list_COLUMN_catagory)));
            res.moveToNext();
        }
        return array_list;
    }
}
