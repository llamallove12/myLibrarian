package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstQuizPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz_page);

        final Button doIt = (Button) findViewById(R.id.NextPageButton);
        doIt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent nextScreen = new Intent(v.getContext(),SecondQuizPage.class);
                        startActivity(nextScreen);


                    }
                }


        );

    }
}
