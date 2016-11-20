package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageAfterQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_after_quiz);

        final Button toMain = (Button) findViewById(R.id.FindABookButton);

        toMain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // go to next page
                        Intent nextScreen = new Intent(v.getContext(),MainActivity.class);
                        startActivity(nextScreen);
                    }
                }
        );
    }
}
