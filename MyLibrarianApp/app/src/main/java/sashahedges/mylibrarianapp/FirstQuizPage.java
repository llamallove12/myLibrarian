package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FirstQuizPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz_page);

        final Button doIt = (Button) findViewById(R.id.NextPageButton);
        final CheckBox ch1 = (CheckBox) findViewById(R.id.SciFi);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.Fantasy);
        final CheckBox ch3 = (CheckBox) findViewById(R.id.Romance);
        final CheckBox ch4 = (CheckBox) findViewById(R.id.Mystery);
        final CheckBox ch5 = (CheckBox) findViewById(R.id.NonFiction);


        doIt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppVars mApp = ((AppVars)getApplicationContext());
                        int userID = mApp.getUser();
                        UserDB db = new UserDB(getApplicationContext());
                        User user = db.getUser(userID);


                        if (ch1.isPressed()){
                            user.setUserGenreList(user.getUserGenreList()+" "+"1");
                        }
                        else if (ch2.isPressed()){
                            user.setUserGenreList(user.getUserGenreList()+" "+"2");
                        }
                        else if (ch3.isPressed()){
                            user.setUserGenreList(user.getUserGenreList()+" "+"3");
                        }
                        else if (ch4.isPressed()){
                            user.setUserGenreList(user.getUserGenreList()+" "+"4");
                        }
                        else if (ch5.isPressed()){
                            user.setUserGenreList(user.getUserGenreList()+" "+"5");
                        }


                        Intent nextScreen = new Intent(v.getContext(),SecondQuizPage.class);
                        startActivity(nextScreen);


                    }
                }


        );

    }
}
