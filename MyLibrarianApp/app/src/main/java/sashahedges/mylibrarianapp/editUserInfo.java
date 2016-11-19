package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.Objects;

public class editUserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);

        final Button cancelButton = (Button) findViewById(R.id.button3);
        final Button saveAndCloseButton = (Button) findViewById(R.id.button2);
        final EditText editEmail = (EditText) findViewById(R.id.editEmailBox);
        final EditText editPassword = (EditText) findViewById(R.id.passwordTextBox);
        final EditText editName = (EditText) findViewById(R.id.nameTextBox);




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

// make current user a global variable


        saveAndCloseButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newEmail = editEmail.getText().toString();       // user input email
                        String newPassword = editPassword.getText().toString(); // user input password
                        String newName = editName.getText().toString();         // user input name

                        currentUser.setUserEmail(newEmail);            // updates the email
                        currentUser.setUserPassword(newPassword);      // updates the password
                        currentUser.setUserName(newName);              // updates the name

                        Intent nextScreen = new Intent(v.getContext(),userProfile.class);
                        startActivity(nextScreen);
                    }
                }
        );

        cancelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextScreen = new Intent(v.getContext(),userProfile.class);
                        startActivity(nextScreen);
                    }
                }
        );
    }
}
