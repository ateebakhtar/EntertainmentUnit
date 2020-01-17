package com.example.admin.entertainmentunit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class showDB extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String show_list_TABLE_NAME = "show_list";
    public static final String show_list_COLUMN_name = "name";
    public static final String show_list_COLUMN_genre = "genre";
    public static final String show_list_COLUMN_length = "length";
    public static final String show_list_COLUMN_director = "director";
    public static final String show_list_COLUMN_rating = "rating";
    public static final String show_list_COLUMN_released = "released";
    public static final String show_list_COLUMN_eppnum = "eppnum";
    public static final String show_list_COLUMN_onair = "onair";
    public static final String show_list_COLUMN_url = "url";
    public static final String show_list_ID = "id";


    public showDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(

                "create table show_list " +
                        "(id integer primary key, name text ,genre text, length text, director text, rating integar, released text,eppnum text,onair text, url text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS show_list");
        System.out.println("Data Entered");
        onCreate(db);
    }
    // yeh auto dalna chiaye
    public boolean insertshow (String name, String item1,String item2,String item3,double item4,String item5, String item6, String item7, String item8) {
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("genre", item1);
        contentValues.put("length", item2);
        contentValues.put("director", item3);
        contentValues.put("rating", item4);
        contentValues.put("released", item5);
        contentValues.put("eppnum", item6);
        contentValues.put("onair", item7);
        contentValues.put("url", item8);
        //insertshow("Castle","Drama","50 min","Andrew W Marlowe","8.2 IMDB","March 2009","173","No","http://cdn.breathecast.com/data/images/full/25015/castle-title-card.jpg");

        db.insert("show_list", null, contentValues);
        return true;
    }

    public Cursor getData(String p) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res,x;
        res = db.rawQuery("select * from show_list where name like '%"+p+"%'",null);
        return res;
    }
    void deletedata(String id)
    {
        System.out.println("playlist item db "+id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("show_list","name like '%"+id+"%'",null);
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, show_list_TABLE_NAME);
        return numRows;
    }


    public ArrayList<String> findAllnames(String a, String b) {

        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<String> array_list = new ArrayList<String>();
//        db.execSQL("DROP TABLE IF EXISTS show_list");
//        db.execSQL(
//
//                "create table show_list " +
//                        "(id integer primary key, name text ,genre text, length text, director text, rating text, released text,eppnum text,onair text, url text)");
//        insertshow("Castle","Drama","50 min","Andrew W Marlowe",8.2,"March 2009","173","No","http://cdn.breathecast.com/data/images/full/25015/castle-title-card.jpg");
//        //hp = new HashMap();
//        insertshow("Daredevil","Action"," 60 min","Drew Goddard",8.7,"April 2015","39","yes","https://terrigen-cdn-dev.marvel.com/content/prod/1x/daredevil_lob_crd_02.jpg");
//
//        insertshow("Stranger Things","Horror"," 55 min","The duffer brothers",8.9,"July 2016","17","yes","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTDJGiYfNFv3sLH8qldcPxKiNLtBXeNj3hI7p_aeZA2l73Co_2");
//
//        insertshow("Sacred games","Mystery"," 47 min","Vikram Chander",9,"July 2018","8","yes","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQC23exgW89thAlXKze5vleGQDgk6r_wh1W0AlDphzGq-X4Sw5p");
//
//        insertshow("Dark","Mystery"," 57 min"," Baran bo Odar",8.6,"Decmber 2017","10","yes","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREps8_A6kqTeif-SLOOMO-zJN_SOGvwhcZr_2UUr46i68xCQTa");
//
//
//
//        insertshow("Friends","Drama"," 22 min","Marta Kauffman",8.9,"March 1994","236","no","https://m.media-amazon.com/images/M/MV5BNDVkYjU0MzctMWRmZi00NTkxLTgwZWEtOWVhYjZlYjllYmU4XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR0,0,182,268_AL_.jpg");
//
//
//        insertshow("Brooklyn Nine Nine","Drama"," 22 min"," Dean Holland",8.4,"September 2013","136","yes","https://upload.wikimedia.org/wikipedia/en/thumb/f/f2/Brooklyn_Nine-Nine_Season_5.jpg/220px-Brooklyn_Nine-Nine_Season_5.jpg");
//
//
//        insertshow("One Tree Hill","Drama"," 50 min"," Paul Johansson",7.7 ,"September 2003","128","no","https://images-na.ssl-images-amazon.com/images/I/51gQGlpyAwL._SY355_.jpg");
//
//
//        insertshow("Riverdale","Mystery"," 45 min"," Lee Toland Krieger",7.5 ,"January 2017","56","yes","https://images-na.ssl-images-amazon.com/images/I/61-HBrwnZAL._SS500.jpg");
//
//
//        insertshow("Luke Cage","Action"," 55 min"," Marc Jobst",7.5 ,"September 2016","10","no","https://upload.wikimedia.org/wikipedia/en/thumb/3/37/Luke_Cage_season_1_poster.jpeg/220px- Luke_Cage_season_1_poster.jpeg");
//
//
//        insertshow("Jessica Jones","Action"," 50 min"," Uta Briesewitz",8.1 ,"November 2015","20","yes","https://m.media-amazon.com/images/M/MV5BMTkxMDk5NTQ3MF5BMl5BanBnXkFtZTgwNzg3ODU3NDM@._V1_SY1000_CR0,0,674,1000_AL_.jpg");
//
//
//        insertshow("Titan","Action"," 45 min"," Brad Anderson",8.3 ,"October 2018","10","yes","https://m.media-amazon.com/images/M/MV5BMTU0NDc4Mjc4N15BMl5BanBnXkFtZTgwNjcyNTM0NjM@._V1_.jpg");
//
//
//        insertshow("Iron Fist","Action"," 55 min"," Stephen Surjik",6.7 ,"March 2017","20","yes","https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Iron_Fist_season_2_poster.jpg/220px- Iron_Fist_season_2_poster.jpg");
//
//
//        insertshow("Defenders","Action"," 50 min"," S. J. Clarkson",7.5 ,"August 2017","10","yes","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPPHQk4f9iob8js- xiEzEtubcaZ8xtQGh3jwdN4zeNp6idt-nA");
//
//        insertshow("Sherlock","Mystery"," 1 hour 28 min"," Paul McGuigan",9.2 ,"October 2010","13","yes","https://static.metacritic.com/images/products/tv/4/525c42f7a1b036d6716878d6b59f28e9.jpg");
//

        Cursor res;
        System.out.println("Data Entered");

        if(a.equals("All") && b.equals("All"))
        {
            res =  db.rawQuery( "select * from show_list", null );
        }
        else if(a.equals("All"))
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from show_list where rating >= "+x+"", null );
        }
        else if(b.equals("All"))
        {
            res =  db.rawQuery( "select * from show_list where genre like '%"+a+"%'", null );
        }
        else
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from show_list where rating >= "+x+" and genre like '%"+a+"%'", null );
        }
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(show_list_COLUMN_name)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> findAllurl(String a, String b) {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();

        System.out.println("Data Entered");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res;

        if(a.equals("All") && b.equals("All"))
        {
            res =  db.rawQuery( "select * from show_list", null );
        }
        else if(a.equals("All"))
        {
            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from show_list where rating >= "+x+"", null );
        }
        else if(b.equals("All"))
        {
            res =  db.rawQuery( "select * from show_list where genre like '%"+a+"%'", null );
        }
        else
        {

            double x = Double.parseDouble(b);
            res =  db.rawQuery( "select * from show_list where rating >= "+x+" and genre like '%"+a+"%'", null );
        }
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(show_list_COLUMN_url)));
            res.moveToNext();
        }
        return array_list;
    }
}
