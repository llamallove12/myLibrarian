package sashahedges.mylibrarianapp;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContentValues;
import java.util.*;

/**
 * Created by brandonvowell on 11/16/16.
 */

public class UserDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "allTheUsers";
    private static final String TABLE_USERS = "Users";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_BOOKLIST = "bookList";
    private static final String KEY_GENRELIST = "genreList";

    public UserDB (Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "(" +
        KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " +
        KEY_EMAIL + " TEXT, " + KEY_PASSWORD + " TEXT, " + KEY_BOOKLIST
        + " TEXT, " + KEY_GENRELIST + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(User usr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, usr.getUserName());
        values.put(KEY_EMAIL, usr.getUserEmail());
        values.put(KEY_PASSWORD, usr.getUserPassword());
        values.put(KEY_BOOKLIST, usr.getUserBookList());
        values.put(KEY_GENRELIST, usr.getUserGenreList());
        db.insert(TABLE_USERS, null, values);
    }

    public void updateUser(User usr, String col){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (col.equals("Name")){
            values.put(KEY_NAME, usr.getUserName());
            db.update(TABLE_USERS, values, "id="+usr.getUserId(), null);

        }
        else if (col.equals("BookList")){
            values.put(KEY_BOOKLIST, usr.getUserBookList());
            db.update(TABLE_USERS, values, "id="+usr.getUserId(), null);

        }
        else if (col.equals("Email")){
            values.put(KEY_EMAIL, usr.getUserEmail());
            db.update(TABLE_USERS, values, "id="+usr.getUserId(), null);

        }
        else if (col.equals("Password")){
            values.put(KEY_PASSWORD, usr.getUserPassword());
            db.update(TABLE_USERS, values, "id="+usr.getUserId(), null);

        }
        else if (col.equals("GenreList")){
            values.put(KEY_GENRELIST, usr.getUserGenreList());
            db.update(TABLE_USERS, values, "id="+usr.getUserId(), null);

        }

    }

    public User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[] {KEY_ID,
        KEY_NAME, KEY_EMAIL, KEY_PASSWORD, KEY_BOOKLIST, KEY_GENRELIST },
         KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        User usr = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5));
        cursor.close();
        return usr;
    }

    //Get all users
    public List<User> getAllUsers() {
        List<User> usrList = new ArrayList<User>();
        String selectQuery = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if(cursor.moveToFirst()) {
            do {
                User usr = new User();
                usr.setUserId(Integer.parseInt(cursor.getString(0)));
                usr.setUserName(cursor.getString(1));
                usr.setUserEmail(cursor.getString(2));
                usr.setUserPassword(cursor.getString(3));
                usr.setUserBookList(cursor.getString(4));
                usr.setUserGenreList(cursor.getString(5));
                usrList.add(usr);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return usrList;
    }

}
