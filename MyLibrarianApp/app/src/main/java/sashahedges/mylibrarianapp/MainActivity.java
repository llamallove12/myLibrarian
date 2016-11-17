package sashahedges.mylibrarianapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Book one = new Book(1, "Flowers", "Romance", "Fun", "Christina Noe", 245);
        Book two = new Book(2, "Grass", "Sci-fi", "Scary", "Sasha Hedges", 420);
        Book three = new Book(3, "Trees", "Mystery", "Bold", "Jessie Melton", 120);
        DBHandler db = new DBHandler(getApplicationContext());
        db.addBook(one);
        db.addBook(two);
        db.addBook(three);
        Book getting = db.getBook(1);
        //System.out.println(getting.getTitle());

        final TextView t = (TextView) findViewById(R.id.textView7);
        t.setText(getting.getTitle());
    }
}
