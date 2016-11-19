package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppVars mApp = ((AppVars)getApplicationContext());

        //------------- adding books --------------------
        DBHandler books = new DBHandler(getApplicationContext());
//        Book book1 = new Book(mApp.getBookId(),"Harry Potter","Fantasy", "Wizard shenanigans","J.K. Rowling",200,5);
//        mApp.incrementBookId();
//
//        Book book2 = new Book(mApp.getBookId(),"Dracula","Mistery", "Vampire shenanigans","Bram Stoker",500,4);
//        mApp.incrementBookId();
//
//        Book book3 = new Book(mApp.getBookId(),"Hitchhiker's Guide to the Galaxy","SciFi", "space shenanigans","Douglas Adams",250,5);
//        mApp.incrementBookId();
//
//        Book book4 = new Book(mApp.getBookId(),"Life of Pi","SciFi","A boy and his tiger","Yann Martel",400,4);
//        mApp.incrementBookId();
//
//        Book book5 = new Book(mApp.getBookId(),"The Martian","SciFi","Mars shenanigans","Andy Weir",300,5);
//        mApp.incrementBookId();
//
//        books.addBook(book1);
//        books.addBook(book2);
//        books.addBook(book3);
//        books.addBook(book4);
//        books.addBook(book5);


//        UserDB users = new UserDB(getApplicationContext());
//        List<User> userL = users.getAllUsers();
//        for (User u : userL){
//            u.setUserBookList("");
//            users.updateUser(u,"BookList");
//        }



        List<Book> booksL = books.getAllBooks();
        for (Book bk : booksL){
            if (bk.getId()>5){
                books.deleteTitle(bk.getId());

            }

        }


        //---------------------

        DBHandler db = new DBHandler(getApplicationContext());
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.mainLayout);

        List<Book> bookList = db.getAllBooks();
        for (final Book bk : bookList){
            TextView t = new TextView(this);
            t.setText(bk.getTitle());
            t.setTextSize(20);
            t.setPadding(0,50,0,0);


            t.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mApp.setBookName(bk.getTitle());
                            Intent nextScreen = new Intent(v.getContext(),BookPage.class);
                            startActivity(nextScreen);
                        }
                    }

            );
            myLayout.addView(t);

            RelativeLayout rLayout = new RelativeLayout(this);


            RatingBar r = new RatingBar(this,null,R.attr.ratingBarStyleSmall);
            //r.setNumStars(5);
            r.setRating(bk.getRating());
            //r.setRating(Float.parseFloat("5.0"));
            rLayout.addView(r);
            myLayout.addView(rLayout);

        }


    }
}
