package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;
import java.util.Objects;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        final Button tempButton = (Button) findViewById(R.id.tempButton); // this button is used to test out the user profile page
        final Button toHistory = (Button) findViewById(R.id.toHistory);

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnSignup = (Button) findViewById(R.id.btnSignup);
        final EditText editEmail = (EditText) findViewById(R.id.editEmail);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                UserDB udb = new UserDB(getApplicationContext());
                List<User> allUsers = udb.getAllUsers();
                boolean inDB = false;
                User currentUser = null;
                for(User u : allUsers) {
                    if(Objects.equals(u.getUserEmail(), email)) {
                        inDB = true;
                        currentUser = u;
                    }
                }
                if(inDB) {
                    if(!Objects.equals(currentUser.getUserPassword(), password)) {
                        Toast.makeText(v.getContext(), "Incorrect Password", Toast.LENGTH_LONG).show();
                        //editEmail.setText("");
                        editPassword.setText("");
                    }
                    else {
                        Intent nextScreen = new Intent(v.getContext(), MainActivity.class);
                        startActivity(nextScreen);
                        // Example for global user
                        AppVars mApp = ((AppVars)getApplicationContext());
                        mApp.setUser(currentUser.getUserId());
                        //int globalVarValue = mApp.getUser();
                        //Toast.makeText(v.getContext(),""+globalVarValue,3).show();
                    }
                }

                else{
                    Toast.makeText(v.getContext(),"User Not Found",Toast.LENGTH_LONG).show();
                    editEmail.setText("");
                    editPassword.setText("");
                }
            }
        });

        btnSignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    Intent nextScreen = new Intent(v.getContext(),Registration.class);
                    startActivity(nextScreen);


                    }
                }

        );

        tempButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent nextScreen = new Intent(v.getContext(),userProfile.class);
                        startActivity(nextScreen);


                    }
                }

        );

        toHistory.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent nextScreen = new Intent(v.getContext(),history.class);
                        startActivity(nextScreen);


                    }
                }

        );


    }
}
