package sashahedges.mylibrarianapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppVars mApp = ((AppVars)getApplicationContext());


        DBHandler books = new DBHandler(getApplicationContext());
        Book book1 = new Book(mApp.getBookId(),"Harry Potter","Fantasy", "Wizard shenanigans","J.K. Rowling",200,5);
        mApp.incrementBookId();

        Book book2 = new Book(mApp.getBookId(),"Dracula","Mistery", "Vampire shenanigans","Bram Stoker",500,4);
        mApp.incrementBookId();

        Book book3 = new Book(mApp.getBookId(),"Hitchhiker's Guide to the Galaxy","SciFi", "space shenanigans","Douglas Adams",250,5);
        mApp.incrementBookId();

        Book book4 = new Book(mApp.getBookId(),"Life of Pi","SciFi","A boy and his tiger","Yann Martel",400,4);
        mApp.incrementBookId();

        books.addBook(book1);
        books.addBook(book2);
        books.addBook(book3);
        books.addBook(book4);




        TextView t = (TextView) findViewById(R.id.textView7);
        t.setText(books.getBook("Life of Pi").getTitle());


    }
}
