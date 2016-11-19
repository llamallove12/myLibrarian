package sashahedges.mylibrarianapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        //get book
        AppVars mApp = ((AppVars)getApplicationContext());
        DBHandler db = new DBHandler(getApplicationContext());
        Book bk = db.getBook(mApp.getBookName());




        t.setText(bk.getTitle());
        author.setText("Author: "+bk.getAuthor());
        pageNumber.setText("Number of Pages: "+bk.getPageCount());
        summary.setText(bk.getDescription());
        r.setRating(bk.getRating());









    }
}
