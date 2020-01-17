package com.example.admin.entertainmentunit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class playlist extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    playlistDB mydb;
    ArrayList array_list;
    int id;
    ArrayList array_url;
    public ArrayList<String> mNames=new ArrayList<>();
    public ArrayList<String> mImageUrls=new ArrayList<>();
    public ArrayList<String> x=new ArrayList<>();
    public ArrayList<String> x1=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        mydb = new playlistDB(this);
        MyApplication s = new MyApplication();
        id = s.getSomeVariable();
        array_list = mydb.getAllnames(id);
        array_url = mydb.getAllurl(id);
        x = mydb.getAllid(id);
        x1= mydb.getAll(id);
        next();

    }


    public void next()
    {
        mImageUrls = array_url;
        mNames = array_list;
        x = mydb.getAllid(id);
        x1 = mydb.getAll(id);
        NewRecycle();
    }

    public void NewRecycle(){
        RecyclerView recyclerView=findViewById(R.id.recyclerView4);

        adapter adapter1 = new adapter(this,mImageUrls,mNames,4,id,x,x1);
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
    void khatam(View view)
    {


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete item");
        builder.setMessage("Do you want to delete this item ??");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
               karo();
            }
        });
        builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){

                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    void karo()
    {
        playlistDB x1 = new playlistDB(this);
        x1.deletetable(id);

        Intent i = new Intent(this,mainmenu.class);
        startActivity(i);
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
