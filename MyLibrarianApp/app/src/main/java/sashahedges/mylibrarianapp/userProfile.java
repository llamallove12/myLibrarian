package sashahedges.mylibrarianapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class userProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        final Button nowNow = (Button) findViewById(R.id.notNow); // recommendation button
        final Button btnSignup = (Button) findViewById(R.id.btnSignup); // change user profile button
        final TextView nameDisplay = (TextView) findViewById(R.id.name); // displays the default user email
        final TextView emailDisplay = (TextView) findViewById(R.id.textView3); // displays the default user email

        AppVars mApp = ((AppVars)getApplicationContext());
        int userID = mApp.getUser();

        UserDB udb = new UserDB(getApplicationContext());
        List<User> allUsers = udb.getAllUsers();
        User currentUser = null;
        for(User u : allUsers) {
            if (Objects.equals(u.getUserId(), userID)) {
                currentUser = u;     // gets the current user object
            }
        }

        nameDisplay.setText(currentUser.getUserName());
        emailDisplay.setText(currentUser.getUserEmail()); // displays the user's actual email

        nowNow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextScreen = new Intent(v.getContext(),FirstQuizPage.class);
                        startActivity(nextScreen);
                    }
                }
        );

        btnSignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextScreen = new Intent(v.getContext(),editUserInfo.class);
                        startActivity(nextScreen);
                    }
                }
        );
    }
}
