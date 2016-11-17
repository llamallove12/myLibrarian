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

            Intent nextScreen = new Intent(v.getContext(),quiz.class);
            startActivity(nextScreen);
        }
        });
    }




}
