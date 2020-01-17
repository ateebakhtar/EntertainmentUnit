package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    void next(View view)
    {
        Intent x = new Intent(this,addmovie.class);
        startActivity(x);
    }
    void next1(View view)
    {
        Intent x = new Intent(this,addsong.class);
        startActivity(x);
    }
    void next2(View view)
    {
        Intent x = new Intent(this,addshow.class);
        startActivity(x);
    }
}
