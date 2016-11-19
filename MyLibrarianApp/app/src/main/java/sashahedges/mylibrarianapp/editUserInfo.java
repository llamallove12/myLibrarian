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

    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);

        final Button cancelButton = (Button) findViewById(R.id.button3);
        final Button saveAndCloseButton = (Button) findViewById(R.id.button2);
        final EditText editEmail = (EditText) findViewById(R.id.editEmailBox);
        final EditText editPassword = (EditText) findViewById(R.id.passwordTextBox);
        final EditText editName = (EditText) findViewById(R.id.nameTextBox);

        final AppVars mApp = ((AppVars)getApplicationContext());
        // int userID = mApp.getUser();

        // UserDB udb = new UserDB(getApplicationContext());
        // currentUser = udb.getUser(userID);

        saveAndCloseButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHandler db = new DBHandler(getApplicationContext());
                        UserDB users = new UserDB(getApplicationContext());
                        User user = users.getUser(mApp.getUser());

                        String newEmail = editEmail.getText().toString();       // user input email
                        String newPassword = editPassword.getText().toString(); // user input password
                        String newName = editName.getText().toString();         // user input name

                        user.setUserName(newName);
                        users.updateUser(currentUser, "Name");

                        user.setUserName(newEmail);
                        users.updateUser(currentUser, "Email");

                        user.setUserName(newPassword);
                        users.updateUser(currentUser, "Password");

                        // user.setUserEmail(newEmail);            // updates the email
                        // user.setUserPassword(newPassword);      // updates the password
                        // user.setUserName(newName);              // updates the name

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
