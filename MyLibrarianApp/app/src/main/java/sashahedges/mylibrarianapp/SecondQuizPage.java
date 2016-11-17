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


        //System.out.println(getting.getTitle());

        final TextView t = (TextView) findViewById(R.id.textView7);


        AppVars mApp = ((AppVars)getApplicationContext());
        int userID = mApp.getUser();
        UserDB db = new UserDB(getApplicationContext());
        final User user = db.getUser(userID);

        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView bookList = (TextView) findViewById(R.id.bookList);
                        bookList.setMovementMethod(new ScrollingMovementMethod());
                        String book = nameBook.getText().toString();
                        String bookListString = bookList.getText().toString();
                        bookList.setText(bookListString+"\n"+book);

                        // add to database
                        user.setUserBookList(user.getUserBookList()+" / " +book);


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
