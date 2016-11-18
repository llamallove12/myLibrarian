package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class addHistoryBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_history_book);

        final Button add = (Button) findViewById(R.id.addHistory);
        final EditText bookName = (EditText) findViewById(R.id.editText2);
        final RatingBar mBar = (RatingBar) findViewById(R.id.ratingBarHistory);

        // get book from db
        //DBHandler db = new DBHandler(getApplicationContext());
        //final Book book = db.getBook(bookName.getText().toString());


        final LinearLayout mLayout = (LinearLayout) findViewById(R.id.linearLayout);




        add.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // add rating to book
                        float[] i = new float[] {mBar.getRating()};


                        //book.setRating(Math.round(i[0]));


                        TextView textView = new TextView(v.getContext());
                        textView.setText(bookName.getText().toString());


                        // add book title and rating to history page
                        mLayout.addView(textView);



                        // go to history page
                        Intent nextScreen = new Intent(v.getContext(),history.class);
                        startActivity(nextScreen);


                    }
                }
        );

    }
}
