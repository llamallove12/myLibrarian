package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class BookPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);
        TextView t = (TextView) findViewById(R.id.bookName);
        TextView author = (TextView) findViewById(R.id.author);
        TextView pageNumber = (TextView) findViewById(R.id.lineNumber);
        TextView summary = (TextView) findViewById(R.id.bookPageSummary);
        RatingBar r = (RatingBar) findViewById(R.id.bookPageRating);
        Button goToOverdrive = (Button) findViewById(R.id.getBookButton);

        //get book
        AppVars mApp = ((AppVars)getApplicationContext());
        DBHandler db = new DBHandler(getApplicationContext());
        Book bk = db.getBook(mApp.getBookName());




        t.setText(bk.getTitle());
        author.setText("Author: "+bk.getAuthor());
        pageNumber.setText("Number of Pages: "+bk.getPageCount());
        summary.setText(bk.getDescription());
        r.setRating(bk.getRating());


        goToOverdrive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent nextScreen = new Intent(v.getContext(),Overdrive.class);
                        startActivity(nextScreen);


                    }
                }

        );







    }
}
