package com.example.admin.entertainmentunit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class movieDB extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "MyDBName.db";

    public static final String movie_list_TABLE_NAME = "movie_list";
    public static final String movie_list_COLUMN_name = "name";
    public static final String movie_list_COLUMN_genre = "genre";
    public static final String movie_list_COLUMN_length = "length";
    public static final String movie_list_COLUMN_director = "director";
    public static final String movie_list_COLUMN_rating = "rating";
    public static final String movie_list_COLUMN_released = "released";
    public static final String movie_list_COLUMN_url = "url";
    public static final String movie_list_ID = "id";


    private HashMap hp;
    public movieDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(

                "create table movie_list " +
                        "(id integer primary key, name text ,genre text, length text,director text,rating integer,released text, url text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS movie_list");
        System.out.println("Data Entered");
        onCreate(db);
    }
    // yeh auto dalna chiaye
    public boolean insertmovie (String name, String item1,String item2,String item3,double item4,String item5,String item6) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("genre", item1);
        contentValues.put("length", item2);
        contentValues.put("director", item3);
        contentValues.put("rating", item4);
        contentValues.put("released", item5);
        contentValues.put("url", item6);

        db.insert("movie_list", null, contentValues);
        return true;
    }

    public Cursor getData(String p) {


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res;



        res = db.rawQuery("select * from movie_list where name like '%"+p+"%'",null);
        System.out.println("Curson in menudisplay after querry "+res.getCount());

        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, movie_list_TABLE_NAME);
        return numRows;
    }


    void deletedata(String id)
    {
        System.out.println("playlist item db "+id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("movie_list","name like '%"+id+"%'",null);
    }





    public ArrayList<String> getAllnames() {
    ArrayList<String> array_list = new ArrayList<String>();
    SQLiteDatabase db = this.getReadableDatabase();

//                db.execSQL("DROP TABLE IF EXISTS movie_list");
//                db.execSQL(
//                "create table movie_list " +
//                        "(id integer primary key, name text ,genre text, length text,director text,rating text,released text, url text)");
//
//        insertmovie("Inception","Fiction","2 hours 28 min","Christopher Nolan",8.8,"july 2010","https://s.s-bol.com/imgbase0/imagebase3/large/FC/1/3/5/8/1002004010708531.jpg");
//
//        insertmovie("Avengers","Action","2 hours 29 min","Russo brothers",8.5,"April 2018","https://images-na.ssl-images-amazon.com/images/I/91zQSWMqIZL._SaY445_.jpg");
//
//        insertmovie("The Dark Knight","Action","2 hours 32 min","Christopher nolan",9,"July 2008","https://is2-ssl.mzstatic.com/image/thumb/Video118/v4/3e/54/c8/3e54c80d-7d7d-5786-0ac9-aca4bafadfda/contsched.jsirdfmq.lsr/268x0w.jpg");
//
//        insertmovie("The Conjuring","Horror", "1 hours 53 min","James Wan ",7.5,"July 2013","https://lightbox-prod.imgix.net/images/assets/100141982-p9379266_v_v8_ag.jpg");
//
//        insertmovie("The Hangover","Comedy","1 hours 40 min","Todd Phillips",6.5,"June 2009","https://media.pathe.nl/nocropthumb/620x955/gfx_content/films/poster/hangover_final.jpg");
//
//    System.out.println("Data Entered");


    Cursor res =  db.rawQuery( "select * from movie_list  ", null );
    res.moveToFirst();

    while(res.isAfterLast() == false){
        array_list.add(res.getString(res.getColumnIndex(movie_list_COLUMN_name)));
        res.moveToNext();
    }
    return array_list;
}

    public ArrayList<String> getAllurl() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();

        System.out.println("Data Entered");
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from movie_list  ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(movie_list_COLUMN_url)));
            res.moveToNext();
        }
        return array_list;
    }


    public ArrayList<String> findAllnames(String a , String b ) {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS movie_list");
//                db.execSQL(
//                "create table movie_list " +
//                        "(id integer primary key, name text ,genre text, length text,director text,rating text,released text, url text)");
//
//        insertmovie("Inception","Fiction","2 hours 28 min","Christopher Nolan",8.8,"july 2010","https://s.s-bol.com/imgbase0/imagebase3/large/FC/1/3/5/8/1002004010708531.jpg");
//
//        insertmovie("Avengers","Action","2 hours 29 min","Russo brothers",8.5,"April 2018","https://images-na.ssl-images-amazon.com/images/I/91zQSWMqIZL._SaY445_.jpg");
//
//        insertmovie("The Dark Knight","Action","2 hours 32 min","Christopher nolan",9,"July 2008","https://is2-ssl.mzstatic.com/image/thumb/Video118/v4/3e/54/c8/3e54c80d-7d7d-5786-0ac9-aca4bafadfda/contsched.jsirdfmq.lsr/268x0w.jpg");
//
//        insertmovie("The Conjuring","Horror", "1 hours 53 min","James Wan ",7.5,"July 2013","https://lightbox-prod.imgix.net/images/assets/100141982-p9379266_v_v8_ag.jpg");
//
//        insertmovie("The Hangover","Comedy","1 hours 40 min","Todd Phillips",6.5,"June 2009","https://media.pathe.nl/nocropthumb/620x955/gfx_content/films/poster/hangover_final.jpg");
////
//    System.out.println("Data Entered");
//        insertmovie("Departed","Action","2 hours 30 min","Martin Scorsese",8.5,"october 2006","https://images-na.ssl-images-amazon.com/images/I/81GmzDazosL._SY445_.jpg");
//
//
//        insertmovie("Sky Scarapper","Action","1 hours 42 min","Rawson marshall",5.9,"july 2018","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXtvPaS8pwDy9PtUhLaS6KKYBi2ixSxa6VzP5J2vW46qxY7fV46Q");
//
//        insertmovie("IT","Horror","2 hours 15 min"," Andrés Muschietti",8,"september 2017","https://cdn-static.denofgeek.com/sites/denofgeek/files/styles/main_wide/public/2017/09/it-2017-movie-poster.jpg?itok=6VymW2gp");
//
//
//        insertmovie("Incredibles","Fiction","1 hours 55 min","Brad Bird",8,"october 2004","https://images.penguinrandomhouse.com/cover/9780736438506");
//
//
//        insertmovie("Grown ups","Comedy","1 hours 42 min"," Dennis Dugan",6,"june 2010","https://upload.wikimedia.org/wikipedia/en/thumb/f/fe/Grownupsmovie.jpg/220px-Grownupsmovie.jpg");
//
//        insertmovie("The Hangover","Comedy","1 hours 40 min","Todd Phillips",6.5,"June 2009","https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/The_Hangover_Part_II_Soundtrack.jpg/220px-The_Hangover_Part_II_Soundtrack.jpg");

        Cursor res;

        System.out.println("Data Entered");
        if(a.equals("All") && b.equals("All"))
        {
            res =  db.rawQuery( "select * from movie_list", null );
        }
        else if(a.equals("All"))
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from movie_list where rating >= "+x+"", null );
        }
        else if(b.equals("All"))
        {
            res =  db.rawQuery( "select * from movie_list where genre like '%"+a+"%'", null );
        }
        else
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from movie_list where rating >= "+x+" and genre like '%"+a+"%'", null );
        }



        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(movie_list_COLUMN_name)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> findAllurl(String a, String b) {
        ArrayList<String> array_list = new ArrayList<String>();
        System.out.println("Data Entered");
        Cursor res;

        SQLiteDatabase db = this.getReadableDatabase();
        if(a.equals("All") && b.equals("All"))
        {
            res =  db.rawQuery( "select * from movie_list", null );
        }
        else if(a.equals("All"))
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from movie_list where rating >= "+x+"", null );
        }
        else if(b.equals("All"))
        {
            res =  db.rawQuery( "select * from movie_list where genre like '%"+a+"%'", null );
        }
        else
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from movie_list where rating >= "+x+" and genre like '%"+a+"%'", null );
        }
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(movie_list_COLUMN_url)));
            res.moveToNext();
        }
        return array_list;
    }

}
