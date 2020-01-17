package com.example.admin.entertainmentunit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class createaccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
    }

    int temp = 0;

    void create(View view) {
        int i = 0, j = 0, k1 = 0;
        EditText name = findViewById(R.id.editText111);
        EditText password = findViewById(R.id.editText121);
        EditText address = findViewById(R.id.editText131);
        EditText number = findViewById(R.id.editText141);
        EditText email = findViewById(R.id.editText151);

        String n = name.getText().toString();
        String p = password.getText().toString();
        String a = address.getText().toString();
        String num = number.getText().toString();
        String e = email.getText().toString();

        loginDB x = new loginDB(this);
        Cursor rs = x.getData(n, p);
        if (rs != null && rs.getCount() > 0) {
            Toast.makeText(this, "Username already exist Renter Username ", Toast.LENGTH_LONG).show();
            i = 1;
        } else if (p.length() < 8) {
            Toast.makeText(this, "Password is to short Renter password", Toast.LENGTH_LONG).show();
        } else if (a.length() < 10) {
            Toast.makeText(this, "Invalid Address Renter Address", Toast.LENGTH_LONG).show();
        } else if (num.length() < 10) {
            Toast.makeText(this, "Invalid Number Renter Number", Toast.LENGTH_LONG).show();

        } else if (android.util.Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            x.insertContact(n, p, a, num, e, 0);
            Toast.makeText(this, "Account has been created ", Toast.LENGTH_LONG).show();
            Intent i1 = new Intent(this, login.class);
            startActivity(i1);
        } else {
            Toast.makeText(this, "Invalid Email Renter Address", Toast.LENGTH_LONG).show();
        }

    }

    void kholo(View view)
    {
        Intent x = new Intent(this,login.class);
        startActivity(x);
    }
}
