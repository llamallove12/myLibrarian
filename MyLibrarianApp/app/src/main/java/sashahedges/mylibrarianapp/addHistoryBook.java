package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class addHistoryBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_history_book);

        final Button add = (Button) findViewById(R.id.addHistory);
        final EditText bookName = (EditText) findViewById(R.id.editText2);
        final RatingBar mBar = (RatingBar) findViewById(R.id.ratingBarHistory);


        // get book from db




        // get user from user db
        final AppVars mApp = ((AppVars)getApplicationContext());




        // get layout on history page
//        final LayoutInflater inflator = getLayoutInflater();
//        final View historyView = inflator.inflate(R.layout.activity_history, null);
//        final LinearLayout mLayout = (LinearLayout) historyView.findViewById(R.id.myLayout);

        add.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHandler db = new DBHandler(getApplicationContext());
                        UserDB users = new UserDB(getApplicationContext());
                        User user = users.getUser(mApp.getUser());
                        Book book = db.getBook(bookName.getText().toString());
                        // add rating to book

                        float[] i = new float[] {mBar.getRating()};

                        book.setRating(Math.round(i[0]));
                        db.updateBook(book,"Rating");

                        // add book to user list


                        user.setUserBookList(user.getUserBookList()+" / " + book.getTitle());
                        users.updateUser(user,"BookList");

                        Toast.makeText(v.getContext(),user.getUserBookList()+"  "+user.getUserName(),Toast.LENGTH_LONG).show();

//                        TextView textView = new TextView(v.getContext());
//                        textView.setText(bookName.getText().toString());


                        //Toast.makeText(v.getContext(),""+mLayout.getId(),Toast.LENGTH_LONG).show();

                        // add book title and rating to history page
                        //mLayout.addView(textView);


                        // go to history page
                        Intent nextScreen = new Intent(v.getContext(),history.class);

                        startActivity(nextScreen);

                    }
                }
        );

    }
}
