package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar x = getSupportActionBar();
        x.hide();
    }
    void openx(View view)
    {
        Intent x = new Intent(this,login.class);
        startActivity(x);
    }
    void next(View view)
    {
        Intent x = new Intent(this,admin.class);
        startActivity(x);
    }

}
