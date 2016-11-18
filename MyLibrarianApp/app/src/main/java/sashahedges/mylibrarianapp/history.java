package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button addHistory = (Button) findViewById(R.id.addBookButton);

        addHistory.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // go to history page
                        Intent nextScreen = new Intent(v.getContext(),addHistoryBook.class);
                        startActivity(nextScreen);


                    }
                }
        );


    }
}
