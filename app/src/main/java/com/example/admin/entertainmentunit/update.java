package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class update extends AppCompatActivity {
    loginDB mydb;
    TextView name ;
    TextView item1;
    TextView item2;
    TextView item3;
    TextView item4;


    int id_To_Update = 0;
    int Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        mydb = new loginDB(this);
        name = (TextView) findViewById(R.id.editText111);
        item1 = (TextView) findViewById(R.id.editText121);
        item2 = (TextView) findViewById(R.id.editText131);
        item3 = (TextView) findViewById(R.id.editText141);
        item4 = (TextView) findViewById(R.id.editText151);



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
                item1.setFocusable(true);
                item1.setClickable(true);

                item2.setText((CharSequence) t2);
                item2.setFocusable(true);
                item2.setClickable(true);

                item3.setText((CharSequence) t3);
                item3.setFocusable(true);
                item3.setClickable(true);

                item4.setText((CharSequence) t4);
                item4.setFocusable(true);
                item4.setClickable(true);



            }
        }

    void updater(View view)
    {
        String n1 = name.getText().toString();
        String n2 = item1.getText().toString();
        String n3 = item2.getText().toString();
        String n4 = item3.getText().toString();
        String n5 = item4.getText().toString();
        MyApplication s = new MyApplication();
        int m =  s.getSomeVariable();

         if (n2.length() < 8) {
            Toast.makeText(this, "Password is to short Renter password", Toast.LENGTH_LONG).show();
        } else if (n3.length() < 10) {
            Toast.makeText(this, "Invalid Address Renter Address", Toast.LENGTH_LONG).show();
        } else if (n4.length() < 10) {
            Toast.makeText(this, "Invalid Number Renter Number", Toast.LENGTH_LONG).show();

        } else if (android.util.Patterns.EMAIL_ADDRESS.matcher(n5).matches()) {
             mydb.updateContact(n1,n2,n3,n4,n5,0,m);
             Intent i = new Intent(this,login.class);
             Toast.makeText(this, "Account has been updated ", Toast.LENGTH_LONG).show();

             startActivity(i);

        } else {
            Toast.makeText(this, "Invalid Email Renter Address", Toast.LENGTH_LONG).show();
        }



    }

}
