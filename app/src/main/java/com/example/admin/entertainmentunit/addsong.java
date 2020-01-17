package com.example.admin.entertainmentunit;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addsong extends AppCompatActivity {
    Spinner w;
    String [] list = {"Retro","Pop","Hip hop","Rock"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsong);

        w = findViewById(R.id.spinner7);
        ArrayAdapter<String> x = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w.setAdapter(x);
    }
    void create(View view)
    {

        EditText n1 = findViewById(R.id.editText24);
        //EditText n2 = findViewById(R.id.editText25);
        EditText n3 = findViewById(R.id.editText26);
        EditText n4 = findViewById(R.id.editText27);
        EditText n5 = findViewById(R.id.editText28);
        EditText n6 = findViewById(R.id.editText29);
        EditText n7 = findViewById(R.id.editText30);

        String n11 = n1.getText().toString();
        String n12 = w.getSelectedItem().toString();
        String n13 = n3.getText().toString();
        String n14 = n4.getText().toString();
        String n15 = n5.getText().toString();
        String n16 = n6.getText().toString();
        String n17 = n7.getText().toString();

        songDB x = new songDB(this);
        Cursor rs = x.getData(n11);
        if(rs != null && rs.getCount() > 0)
        {
            Toast.makeText(this, " already exist ", Toast.LENGTH_LONG).show();
        }
        else if( n12.length() < 1 || n13.length() < 1 ||n14.length() < 1 ||n15.length() < 1 ||n16.length() < 1 ||n17.length() < 1 )
        {
            Toast.makeText(this, " too short ", Toast.LENGTH_LONG).show();
        }
        else
        {

            x.insertsong(n11,n12,n13,n14,n15,n16,n17);
            Toast.makeText(this, " added ", Toast.LENGTH_LONG).show();
        }
    }
    void remove(View view)
    {
        EditText n1 = findViewById(R.id.editText32);
        String n11 = n1.getText().toString();
        songDB x = new songDB(this);
         Cursor rs = x.getData(n11);
        if(rs != null && rs.getCount() > 0)
        {
            Toast.makeText(this, " Removed", Toast.LENGTH_LONG).show();
            x.deletedata(n11);

        }
        else
        {
            Toast.makeText(this, " Not in list", Toast.LENGTH_SHORT).show();
        }

    }
}
