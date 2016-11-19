package sashahedges.mylibrarianapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SecondQuizPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_quiz_page);
        final Button addButton = (Button) findViewById(R.id.AddButton);
        final Button finishButton = (Button) findViewById(R.id.FinishButton);
        final EditText nameBook = (EditText) findViewById(R.id.nameBook);




        AppVars mApp = ((AppVars)getApplicationContext());
        final int userID = mApp.getUser();







        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LinearLayout l = (LinearLayout) findViewById(R.id.bookLayout);


                        // figure scrolling out
                        //r.setMovementMethod(new ScrollingMovementMethod());

                        LinearLayout r = new LinearLayout(v.getContext());
                        r.setOrientation(LinearLayout.HORIZONTAL);



                        String book = nameBook.getText().toString();
                        TextView t = new TextView(v.getContext());
                        t.setText(book);
                        r.addView(t);



                        // RATING BAR
                        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
                        float[] i = new float[] {rating.getRating()};

                        RatingBar rate = new RatingBar(v.getContext(), null, android.R.attr.ratingBarStyleSmall);
                        rate.setRating(i[0]);
                        r.addView(rate);
                        l.addView(r);


                        // add rating to book db
                        DBHandler books = new DBHandler(getApplicationContext());
                        Book bk = books.getBook(book);
                        bk.setRating(Math.round(i[0]));
                        books.updateBook(bk,"Rating");

                        // add book to user database
                        UserDB db = new UserDB(getApplicationContext());
                        User user = db.getUser(userID);
                        user.setUserBookList(user.getUserBookList()+" / " +book);
                        db.updateUser(user,"BookList");




                        nameBook.setText("");
                        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        mgr.hideSoftInputFromWindow(nameBook.getWindowToken(),0);

                    }
                }



        );

        finishButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // add info to database
                        // go to next page


                        Intent nextScreen = new Intent(v.getContext(),PageAfterQuiz.class);
                        startActivity(nextScreen);

                    }
                }

        );


    }
}
