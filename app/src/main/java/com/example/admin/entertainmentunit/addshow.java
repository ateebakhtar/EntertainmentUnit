package com.example.admin.entertainmentunit;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class addshow extends AppCompatActivity {
    String [] list = {"Drama","Action","Horror","Mystery"};
    String text;
    Spinner w;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshow);

        //textView56

        w = findViewById(R.id.spinner6);
        ArrayAdapter<String> x = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w.setAdapter(x);


        mDisplayDate = (TextView) findViewById(R.id.textView56);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        addshow.this,
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

        EditText n1 = findViewById(R.id.editText31);
        //EditText n2 = findViewById(R.id.editText33);
        EditText n3 = findViewById(R.id.editText34);
        EditText n4 = findViewById(R.id.editText35);
        EditText n5 = findViewById(R.id.editText36);
        TextView n6 = findViewById(R.id.textView56);
        EditText n7 = findViewById(R.id.editText38);
        EditText n8 = findViewById(R.id.editText39);
        EditText n9 = findViewById(R.id.editText40);

        String n11 = n1.getText().toString();
        String n12 = w.getSelectedItem().toString();
        String n13 = n3.getText().toString();
        String n14 = n4.getText().toString();
        String n15 = n5.getText().toString();
        String n16 = n6.getText().toString();
        String n17 = n7.getText().toString();
        String n18 = n8.getText().toString();
        String n19 = n9.getText().toString();
        double x1 = Double.parseDouble(n15);
        showDB x = new showDB(this);
        Cursor rs = x.getData(n11);
        if(rs != null && rs.getCount() > 0)
        {
            Toast.makeText(this, " already exist ", Toast.LENGTH_LONG).show();
        }
        else if( n12.length() < 1 || n13.length() < 1 ||n14.length() < 1 ||n15.length() < 1 ||n16.length() < 1 ||n17.length() < 1 ||n18.length() < 1 ||n19.length() < 1 )
        {
            Toast.makeText(this, " too short ", Toast.LENGTH_LONG).show();
        }
        else if(x1 > 10 || x1 < 0)
        {
            Toast.makeText(this, " wrong rating ", Toast.LENGTH_LONG).show();
        }
        else
        {
            x.insertshow(n11,n12,n13,n14,x1,n16,n17,n18,n19);
            Toast.makeText(this, " added ", Toast.LENGTH_LONG).show();
        }
    }
    void remove(View view)
    {
        EditText n1 = findViewById(R.id.editText42);
        String n11 = n1.getText().toString();
        showDB x = new showDB(this);

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
