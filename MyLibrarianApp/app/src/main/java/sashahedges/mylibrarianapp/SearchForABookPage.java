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
import android.widget.RadioButton;
import android.widget.TextView;

public class SearchForABookPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_abook_page);
        final RadioButton TitleRB = (RadioButton) findViewById(R.id.TitleRadioButton);
        final RadioButton AuthorRB = (RadioButton) findViewById(R.id.AuthorRadioButton);
        final RadioButton ISBNRB = (RadioButton) findViewById(R.id.ISBNRadioButton);
        final EditText TitleTB = (EditText) findViewById(R.id.TitleTextBox);
        final EditText AuthorTB = (EditText) findViewById(R.id.AuthorTextBox);
        final EditText ISBNTB = (EditText) findViewById(R.id.ISBNTextBox);

        TitleRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView bookList = (TextView) findViewById(R.id.ListOfBooks);
                bookList.setMovementMethod(new ScrollingMovementMethod());
                String book = TitleTB.getText().toString();
                String bookListString = bookList.getText().toString();
                bookList.setText(bookListString+"\n"+book);
                TitleTB.setText("");
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(TitleTB.getWindowToken(),0);
            }
        });


        TitleRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ISBNRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}
