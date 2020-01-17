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

public class show extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    showDB mydb;
    ArrayList array_list;
    ArrayList array_url;
    Spinner w;
    Spinner w1;
    String [] list = {"All","Drama","Action","Horror","Mystery"};
    String [] list1 = {"All","1","2","3","4","5","6","7","8","9"};
    public ArrayList<String> mNames=new ArrayList<>();
    public ArrayList<String> mImageUrls=new ArrayList<>();
    public ArrayList<String> x=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mydb = new showDB(this);
// this how you dfo spinners
        w = findViewById(R.id.spinner);
        ArrayAdapter<String> x = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        //x.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w.setAdapter(x);

        w1= findViewById(R.id.spinner2);
        ArrayAdapter<String> x1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list1);
        //x.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        x1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w1.setAdapter(x1);
      mid();
    }
    void mid()
    {
        String m = w.getSelectedItem().toString();
        String n = w1.getSelectedItem().toString();
        array_list = mydb.findAllnames(m,n);
        array_url =  mydb.findAllurl(m,n);
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
        RecyclerView recyclerView=findViewById(R.id.recyclerView3);
        MyApplication s = new MyApplication();
        int id_To_Update =  s.getSomeVariable();
        adapter adapter1 = new adapter(this,mImageUrls,mNames,3,id_To_Update);
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
