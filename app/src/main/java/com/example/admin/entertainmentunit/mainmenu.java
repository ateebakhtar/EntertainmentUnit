package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }
    public void openmovie(View view)
    {

        Intent x1 = new Intent(this,movie.class);

        startActivity(x1);
    }
    void opensong(View view)
    {

        Intent x1 = new Intent(this,song.class);

        startActivity(x1);
    }
    void openshow(View view)
    {

        Intent x1 = new Intent(this,show.class);

        startActivity(x1);
    }
    void openprofile(View view)
    {

        Intent p = new Intent(this,viewlogin.class);
        startActivity(p);
    }
    void lop(View view)
    {

        Intent p = new Intent(this,login.class);
        startActivity(p);
    }
    void open(View view)
    {

        Intent x1 = new Intent(this,playlist.class);
        startActivity(x1);
    }
}
