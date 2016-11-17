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

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "allTheBooks";
    private static final String TABLE_BOOKS = "Books";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PAGECOUNT = "pageCount";
    private static final String KEY_RATING = "rating";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_BOOKS + "(" +
        KEY_ID + " INTEGER PRIMARY KEY, " + KEY_TITLE + " TEXT, " +
        KEY_GENRE + " TEXT, " + KEY_DESCRIPTION + " TEXT, " + KEY_AUTHOR + " TEXT, "
        + KEY_PAGECOUNT + " INTEGER, " + KEY_RATING + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }

    public void addBook(Book bk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, bk.getTitle());
        values.put(KEY_GENRE, bk.getGenre());
        values.put(KEY_DESCRIPTION, bk.getDescription());
        values.put(KEY_AUTHOR, bk.getAuthor());
        values.put(KEY_PAGECOUNT, bk.getPageCount());
        values.put(KEY_RATING, bk.getRating());
        db.insert(TABLE_BOOKS, null, values);
        db.close();
    }

    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BOOKS, new String[] { KEY_ID,
                KEY_TITLE, KEY_GENRE, KEY_DESCRIPTION, KEY_AUTHOR, KEY_PAGECOUNT, KEY_RATING }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Book contact = new Book(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)));
        cursor.close();
        return contact;
    }

    // Get all books
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<Book>();
        String selectQuery = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if(cursor.moveToFirst()) {
            do {
                Book bk = new Book();
                bk.setId(Integer.parseInt(cursor.getString(0)));
                bk.setTitle(cursor.getString(1));
                bk.setGenre(cursor.getString(2));
                bk.setDescription(cursor.getString(3));
                bk.setAuthor(cursor.getString(4));
                bk.setPageCount(Integer.parseInt(cursor.getString(5)));
                bk.setRating(Integer.parseInt(cursor.getString(6)));
                bookList.add(bk);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return bookList;
    }

}
