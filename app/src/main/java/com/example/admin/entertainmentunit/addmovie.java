package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class addmovie extends AppCompatActivity {
    Spinner w;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String [] list = {"Fiction","Action","Horror","Comedy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmovie);

        w = findViewById(R.id.spinner9);
        ArrayAdapter<String> x = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w.setAdapter(x);


        mDisplayDate = (TextView) findViewById(R.id.textView58);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        addmovie.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = day + "-" + month + "-" + year;
                mDisplayDate.setText(date);
            }
        };
    }
    void create(View view)
    {

        EditText n1 = findViewById(R.id.editText11);
        //EditText n2 = findViewById(R.id.editText12);
        EditText n3 = findViewById(R.id.editText13);
        EditText n4 = findViewById(R.id.editText14);
        EditText n5 = findViewById(R.id.editText12);
        TextView n6 = findViewById(R.id.textView58);
        EditText n7 = findViewById(R.id.editText22);

        String n11 = n1.getText().toString();
        String n12 = w.getSelectedItem().toString();
        String n13 = n3.getText().toString();
        String n14 = n4.getText().toString();
        String n15 = n5.getText().toString();
        String n16 = n6.getText().toString();
        String n17 = n7.getText().toString();
        double temp = Double.parseDouble(n15);
        movieDB x = new movieDB(this);
        Cursor rs = x.getData(n11);
        if(rs != null && rs.getCount() > 0)
        {
            Toast.makeText(this, " already exist ", Toast.LENGTH_LONG).show();
        }
        else if( n12.length() < 1 || n13.length() < 1 ||n14.length() < 1 ||n15.length() < 1 ||n16.length() < 1 ||n17.length() < 1 )
        {
            Toast.makeText(this, " too short ", Toast.LENGTH_LONG).show();
        }
        else if(temp > 10 || temp < 0)
        {
            Toast.makeText(this, " wrong rating ", Toast.LENGTH_LONG).show();
        }
        else
        {

            x.insertmovie(n11,n12,n13,n14,temp,n16,n17);
            Toast.makeText(this, " added ", Toast.LENGTH_LONG).show();
        }
    }
    void remove(View view)
    {
        EditText n1 = findViewById(R.id.editText23);
        String n11 = n1.getText().toString();
        movieDB x = new movieDB(this);
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
