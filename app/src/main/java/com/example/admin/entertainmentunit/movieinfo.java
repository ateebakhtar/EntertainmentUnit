package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class movieinfo extends AppCompatActivity {


    String nam ;
    String t1 ;
    String t2 ;
    String t3 ;
    String t4 ;
    String t5 ;
    String t6 ;
    int x1;
    movieDB mydb;
    TextView name ;
    TextView item1;
    TextView item2;
    TextView item3;
    TextView item4;
    TextView item5;
    int id_To_Update ;
    int Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieinfo);

        mydb = new movieDB(this);
        name = (TextView) findViewById(R.id.editText8);
        item1 = (TextView) findViewById(R.id.editText131);
        item2 = (TextView) findViewById(R.id.editText9);
        item3 = (TextView) findViewById(R.id.editText10);
        item4 = (TextView) findViewById(R.id.editText111);
        item5 = (TextView) findViewById(R.id.editText121);


        Bundle extras = getIntent().getExtras();
        Value = extras.getInt("id");
        System.out.println(Value);
        String p = extras.getString("name");
        if (extras != null) {


            if (Value > 0) {
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(p);
                id_To_Update = Value;
                rs.moveToFirst();
                System.out.println(rs.getCount());
                if (rs != null && rs.getCount() > 0) {
                    nam = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_name));
                    t1 = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_genre));
                    t2 = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_length));
                    t3 = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_director));
                    t4 = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_rating));
                    t5 = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_released));
                    t6 = rs.getString(rs.getColumnIndex(movieDB.movie_list_COLUMN_url));
                    x1 = rs.getInt(rs.getColumnIndex(movieDB.movie_list_ID));
                } else
                {
                    System.out.println("SOMETIUNGNAG");
                }



                if (!rs.isClosed()) {
                    rs.close();
                }

                name.setText((CharSequence) nam);
                name.setFocusable(false);
                name.setClickable(false);

                item1.setText((CharSequence) t1);
                item1.setFocusable(false);
                item1.setClickable(false);

                item2.setText((CharSequence) t2);
                item2.setFocusable(false);
                item2.setClickable(false);

                item3.setText((CharSequence) t3);
                item3.setFocusable(false);
                item3.setClickable(false);

                item4.setText((CharSequence) t4);
                item4.setFocusable(false);
                item4.setClickable(false);

                item5.setText((CharSequence) t5);
                item5.setFocusable(false);
                item5.setClickable(false);


            }
        }
    }


    void back(View view)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    void addtoplaylist(View view)
    {
        playlistDB x = new playlistDB(this);
        MyApplication s = new MyApplication();
        id_To_Update =  s.getSomeVariable();
        System.out.println(id_To_Update);
        Cursor rs = x.getData(nam,id_To_Update);
        if(rs != null && rs.getCount() > 0)
        {
            Toast.makeText(this, " Already In Playlist", Toast.LENGTH_SHORT).show();
        }
        else
        {
            x.insertlist(nam,t1,"movie",x1,t6,id_To_Update);
        }

    }
}
