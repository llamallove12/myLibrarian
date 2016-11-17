package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Button btnUserProfile = (Button) findViewById(R.id.goUserProfileButton);
        btnUserProfile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent nextScreen = new Intent(v.getContext(),userProfile.class);
            startActivity(nextScreen);
        }
        });


        final Button btnBookSearch = (Button) findViewById(R.id.goSearchButton);
        btnBookSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // UNFINISHED, fix class
                Intent nextScreen = new Intent(v.getContext(),quiz.class);
                startActivity(nextScreen);
            }
        });


        final Button btnHistory = (Button) findViewById(R.id.goHistoryButton);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextScreen = new Intent(v.getContext(),history.class);
                startActivity(nextScreen);
            }
        });


        final Button btnOverdrive = (Button) findViewById(R.id.goOverdriveButton);
        btnOverdrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // UNFINISHED, fix class
                Intent nextScreen = new Intent(v.getContext(),quiz.class);
                startActivity(nextScreen);
            }
        });


    }




}
