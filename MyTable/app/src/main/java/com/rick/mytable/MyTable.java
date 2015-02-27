package com.rick.mytable;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Rick on 26/02/15.
 */
public class MyTable extends Application {

    public void onCreate(){
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "tlPnTwm1dVIzuuPXaJUoxyklBqbzJIFiU3FTyRtn", "PaPupKDHMHb4XFx9rOZk1hnOrwP6YOgrT7U3x7QN");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);


    }
}
