package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Button doIt = (Button) findViewById(R.id.doIt);
        final Button notNow = (Button) findViewById(R.id.changeUserInfoButton);
        doIt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent nextScreen = new Intent(v.getContext(),FirstQuizPage.class);
                        startActivity(nextScreen);


                    }
                }

        );

        notNow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent nextScreen = new Intent(v.getContext(),MainActivity.class);
                        startActivity(nextScreen);


                    }
                }

        );


    }
}
