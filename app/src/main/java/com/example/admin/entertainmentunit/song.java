package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class song extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    songDB mydb;
    Spinner w;
    String [] list = {"All","Retro","Pop","Hip hop","Rock"};
    ArrayList array_list;
    ArrayList array_url;
     public ArrayList<String> mNames=new ArrayList<>();
     public ArrayList<String> mImageUrls=new ArrayList<>();
    static int status = 0;
    public ArrayList<String> x=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        w = findViewById(R.id.spinner5);
        ArrayAdapter<String> x = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w.setAdapter(x);
        mydb = new songDB(this);
        mid();
    }

    void mid()
    {
        String m = w.getSelectedItem().toString();
        array_list = mydb.findAllnames(m);
        array_url =  mydb.findAllurl(m);
        next();
    }

    void find(View view)
    {
        mid();
    }



    public void next()
    {
        mImageUrls = array_url;
        mNames = array_list;
        NewRecycle();
    }

    public void NewRecycle(){
        RecyclerView recyclerView=findViewById(R.id.recyclerView2);
        MyApplication s = new MyApplication();
        int id_To_Update =  s.getSomeVariable();
        adapter adapter1 = new adapter(this,mImageUrls,mNames,2,id_To_Update);
        if(mImageUrls == null || mNames == null)
        {
            System.out.println("array lists are null");
        }
        if(adapter1!=null)
        {
            recyclerView.setAdapter(adapter1);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else
        {
            System.out.println("NULL COMING");
        }


    }

    void back(View view)
    {

        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
    }
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }
}
