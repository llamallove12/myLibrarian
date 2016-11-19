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
import android.widget.RadioButton;
import android.widget.TextView;

public class SearchForABookPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_abook_page);

        final RadioButton TitleRB = (RadioButton) findViewById(R.id.TitleRadioButton);
        final RadioButton AuthorRB = (RadioButton) findViewById(R.id.AuthorRadioButton);

        final EditText TitleTB = (EditText) findViewById(R.id.textBox);


        Button search = (Button) findViewById(R.id.searchButton);

        // Book database
        final DBHandler db = new DBHandler(getApplicationContext());


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout bookList = (LinearLayout) findViewById(R.id.listOfBooks);
                TextView t = (TextView) findViewById(R.id.searchBookName);

                final AppVars mApp = ((AppVars)getApplicationContext());
                if (TitleRB.isChecked()){
                    String bookTitle = TitleTB.getText().toString();
                    final Book bk = db.getBook(bookTitle);
                    if(bk==null){
                        t.setText("No Titles Found");
                    }
                    else{
                        t.setText(bk.getTitle());
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
                    }
                }
                else if(AuthorRB.isChecked()){
                    String bookAuthor = TitleTB.getText().toString();
                    final Book bk = db.getBookByAuthor(bookAuthor);
                    if(bk==null){
                        t.setText("No Titles Found");
                    }
                    else{
                        t.setText(bk.getTitle());
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
                    }

                }

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(TitleTB.getWindowToken(),0);



            }
        });









    }
}
