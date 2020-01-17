package com.example.admin.entertainmentunit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class songDB extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String song_list_TABLE_NAME = "song_list";
    public static final String song_list_COLUMN_name = "name";
    public static final String song_list_COLUMN_genre = "genre";
    public static final String song_list_COLUMN_length = "length";
    public static final String song_list_COLUMN_singer = "singer";
    public static final String song_list_COLUMN_movie = "movie";
    public static final String song_list_COLUMN_band = "band";
    public static final String song_list_COLUMN_url = "url";
    public static final String song_list_ID = "id";
    private HashMap hp;
    public songDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(

                "create table song_list " +
                        "(id integer primary key, name text ,genre text, length text,singer text,movie text,band text,url text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS song_list");
        System.out.println("Data Entered");
        onCreate(db);
    }
    // yeh auto dalna chiaye
    public boolean insertsong (String name, String item1,String item2,String item3,String item4,String item5,String item6) {
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("genre", item1);
        contentValues.put("length", item2);
        contentValues.put("singer", item3);
        contentValues.put("movie", item4);
        contentValues.put("band", item5);
        contentValues.put("url", item6);

        db.insert("song_list", null, contentValues);
        return true;
    }

    void deletedata(String id)
    {
        System.out.println("playlist item db "+id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("song_list","name like '%"+id+"%'",null);
    }
    public Cursor getData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res,x;
        System.out.println(id);
        res = db.rawQuery("select * from song_list where name like '%"+id+"%'",null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, song_list_TABLE_NAME);
        return numRows;
    }
    public ArrayList<String> getAllnames() {
        ArrayList<String> array_list = new ArrayList<String>();
        System.out.println("Data Entered");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from song_list  ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(song_list_COLUMN_name)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> getAllurl() {
        ArrayList<String> array_list = new ArrayList<String>();
        System.out.println("Data Entered");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from song_list  ", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(song_list_COLUMN_url)));
            res.moveToNext();
        }
        return array_list;
    }


    public ArrayList<String> findAllurl(String x) {
        ArrayList<String> array_list = new ArrayList<String>();
        System.out.println("Data Entered");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res;
        if(x.equals("All"))
        {
            res =  db.rawQuery( "select * from song_list  ", null );
        }
        else {
            res =  db.rawQuery( "select * from song_list where genre like '%"+x+"%' ", null );
        }
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(song_list_COLUMN_url)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> findAllnames(String x) {
        ArrayList<String> array_list = new ArrayList<String>();
        System.out.println("Data Entered");
        SQLiteDatabase db = this.getReadableDatabase();

//        db.execSQL("DROP TABLE IF EXISTS song_list");
//        db.execSQL(
//
//                "create table song_list " +
//                        "(id integer primary key, name text ,genre text, length text,singer text,movie text,band text,url text)");
//
//        insertsong("Pumped up Kicks","Retro","4 min 16 sec","Mark Foster","none","Foster the People","https://direct.rhapsody.com/imageserver/images/Alb.49853819/500x500.jpg");
//
//        insertsong("Treat You Better","Pop","3 min 07 sec","Shawn mendis","none","none","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQI_gcVOqWAPuuLw5BzP3zfhqv5I5AhVvTXA7WSANiPPgwSm0JN");
//
//        insertsong("Love the way you lie","Hip hop","4 min 23 sec","Eminem","none","none","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1Nv6ecGgLx_4glLs6ZPfPpHwEhNVppUr4nP7SMHD_Jqlp2n25");
//
//        insertsong("Sky full of stars","Pop","4 min 28 sec","Chris Martin","none","Coldplay","https://i.ytimg.com/vi/hGF-C78hojI/maxresdefault.jpg");
//
//
//        insertsong("perfect","Pop","4 min 23 sec","Ed Sheeran","none","none","https://images-na.ssl-images-amazon.com/images/I/41Gql9t3hOL._SS500.jpg");
//
//
//        insertsong("Grenade","Pop","3 min 42 sec","Bruno mars","none","none","https://i.pinimg.com/originals/c4/71/20/c471209489cdb73365ec0c23ee37c149.jpg");
//
//        insertsong("Hero","Pop","4 min 24 sec","Enrique iglesias","none","none","https://upload.wikimedia.org/wikipedia/en/thumb/0/04/Enrique_-_Hero.jpg/220px-Enrique_-_Hero.jpg");
//
//        insertsong("A thousand years","Pop","4 min 45 sec","Christina Perri","none","none","https://i.ytimg.com/vi/rtOvBOTyX00/maxresdefault.jpg");
//
//        insertsong("Girl like you","Pop","3 min 55 sec","Maroon 5","none","none","http://twincitiesmedia.net/blog/wp-content/uploads/2018/09/33944193_10156411530658482_4988174798531067904_o.jpg");
//
//        insertsong("Lighters","Hip hop","5 min 03 sec","Eminem","none","none","https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Bad_Meets_Evil_-_Lighters_%28Bruno_Mars_single%29.jpg/220px-Bad_Meets_Evil_-_Lighters_%28Bruno_Mars_single%29.jpg");
//
//        insertsong("Natural","Rock","3 min 55 sec","Dan Reynolds","none","Imagine dragons","https://m.media-amazon.com/images/M/MV5BY2U4MGI0MWUtODE0MS00YjliLWI3MmQtYTZhYWEwYWFmMTMyXkEyXkFqcGdeQXVyNDQ5MDYzMTk@._V1_UY268_CR9,0,182,268_AL_.jpg");
//
//        insertsong("We will Rock you","Rock","2 min 02 sec","Brian may","none","Queen","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIqC3j6gBLt3VoimSi-gcauF05FvDRNZ_05-T6ABtlbxxs3RS9");
//
//        insertsong("We will Rock you","Rock","3 min 20 sec","Kesha","none","none","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxVdWSEiNDDr0MxgtthJpQtyi8WECdOFJOjWl2s6ZPbq-gFAPR");
//
//        insertsong("Cheap thrills","pop","3 min 30 sec","Sia","none","none","https://images-eu.ssl-images-amazon.com/images/I/51WrYbWg47L._SS500.jpg");
//
//        insertsong("Without me","Hip hop","4 min 50 sec","Eminem","none","none","https://upload.wikimedia.org/wikipedia/en/thumb/a/ad/Eminem_-_Without_Me_CD_cover.jpg/220px-Eminem_-_Without_Me_CD_cover.jpg");


        Cursor res;
        if(x.equals("All"))
        {
            res =  db.rawQuery( "select * from song_list  ", null );
        }
        else {
             res =  db.rawQuery( "select * from song_list where genre like '%"+x+"%' ", null );
        }
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(song_list_COLUMN_name)));
            res.moveToNext();
        }
        return array_list;
    }
}
