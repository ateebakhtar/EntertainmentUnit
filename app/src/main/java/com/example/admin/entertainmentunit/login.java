package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    void loginit (View view)
    {
        EditText x = findViewById(R.id.editText9);
        EditText y = findViewById(R.id.editText10);

        String x1 = x.getText().toString();
        String y1 = y.getText().toString();

        loginDB a = new loginDB(this);
        Cursor rs = a.getData(x1,y1);
        if (rs != null && rs.getCount() > 0) {
            rs.moveToFirst();
            String nam = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_NAME));
            String t1 = rs.getString(rs.getColumnIndex(loginDB.login_list_COLUMN_password));
            int x3 = rs.getInt(rs.getColumnIndex(loginDB.login_list_ID));
            int t2 = rs.getInt(rs.getColumnIndex(loginDB.login_list_ID));
            System.out.println(nam+t1);
            if(t1.equals(y1))
            {
                MyApplication s = new MyApplication();
                s.setSomeVariable(t2);
                int temp = s.getSomeVariable();
                System.out.println(t2);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("csid",t2);
                Intent i = new Intent(this,mainmenu.class);
                i.putExtras(dataBundle);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Incorrect Password ", Toast.LENGTH_SHORT).show();
            }

        } else
        {
            Toast.makeText(this, "Incorrect UserName or Password ", Toast.LENGTH_SHORT).show();
        }
    }
    void openx(View view)
    {
        Intent x = new Intent(this,createaccount.class);
        startActivity(x);
    }
}
