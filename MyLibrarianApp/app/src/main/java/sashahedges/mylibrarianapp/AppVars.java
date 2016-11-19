package sashahedges.mylibrarianapp;

import android.app.Application;

/**
 * Created by Alexandra on 11/17/2016.
 */

public class AppVars extends Application {

    private int user = 1;
    private int bookId=1;
    private String bookName="";

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String name){
        bookName=name;

    }

    public int getBookId(){
        return bookId;
    }

    public void incrementBookId(){
        bookId++;

    }

    public int getUser(){
        return user;

    }

    public void setUser(int id){
        this.user = id;

    }

}
