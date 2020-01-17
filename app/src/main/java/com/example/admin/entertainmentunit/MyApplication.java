package com.example.admin.entertainmentunit;

import android.app.Application;

public class MyApplication extends Application {

    private static int someVariable;

    public int getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(int someVariable) {
        this.someVariable = someVariable;
    }
}