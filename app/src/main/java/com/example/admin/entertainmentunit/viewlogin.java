package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class viewlogin extends AppCompatActivity {
    loginDB mydb;
    TextView name ;
    TextView item1;
    TextView item2;
    TextView item3;
    TextView item4;


    int id_To_Update ;
    int Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_viewlogin);

    mydb = new loginDB(this);
    name = (TextView) findViewById(R.id.editText111);
    item1 = (TextView) findViewById(R.id.editText121);
    item2 = (TextView) findViewById(R.id.editText131);
    item3 = (TextView) findViewById(R.id.editText141);
    item4 = (TextView) findViewById(R.id.editText151);




        //String v = extras.getString("id");
            MyApplication s = new MyApplication();
            Value =  s.getSomeVariable();
        System.out.println(Value);

        if (Value > 0) {
            //means this is the view part not the add contact part.
            Cursor rs = mydb.getview(Value);
            id_To_Update = Value;
            rs.moveToFirst();
            String nam = "Something";
            String t1 = null;
            String t2 = null;
            String t3 = null;
            String t4 = null;



            System.out.println(rs.getCount());
            if (rs != null && rs.getCount() > 0) {
                nam = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_NAME));
                t1 = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_password));
                t2 = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_address));
                t3 = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_number));
                t4 = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_email));
                System.out.println(t1 + t2 + t3 + t4);

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



        }
    }

    void create(View view)
    {
        Intent p = new Intent(this,update.class);
        startActivity(p);
    }
}
