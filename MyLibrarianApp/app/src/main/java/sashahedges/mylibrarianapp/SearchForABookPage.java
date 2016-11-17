package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class SearchForABookPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_abook_page);

        final RadioButton TitleRB = (RadioButton) findViewById(R.id.TitleRadioButton);
        TitleRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView TitleTB = (TextView) findViewById(R.id.TitleTextBox);
                TitleTB.setText(getting.getTitle());
            }
        });


        final RadioButton AuthorRB = (RadioButton) findViewById(R.id.AuthorRadioButton);
        TitleRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView AutorTB = (TextView) findViewById(R.id.AuthorTextBox);
                AuthorTB.setText(getting.getAuthor());
            }
        });

        final RadioButton ISBNRB = (RadioButton) findViewById(R.id.ISBNRadioButton);
        ISBNRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView ISBNTB = (TextView) findViewById(R.id.ISBNTextBox);
                ISBNTB.setText(getting.getISBN());
            }
        });





    }
}
