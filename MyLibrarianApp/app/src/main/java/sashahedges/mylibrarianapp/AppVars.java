package sashahedges.mylibrarianapp;

import android.app.Application;

/**
 * Created by Alexandra on 11/17/2016.
 */

public class AppVars extends Application {

    private int user;
    public int getUser(){
        return user;

    }

    public void setUser(int id){
        this.user = id;

    }

}
