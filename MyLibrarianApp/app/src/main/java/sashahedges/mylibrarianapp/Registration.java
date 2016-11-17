package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final Button btnSignup = (Button) findViewById(R.id.btnSignup2);
        final EditText editEmail = (EditText) findViewById(R.id.editEmailReg);
        final EditText editPassword = (EditText) findViewById(R.id.editPassReg);
        final EditText editPasswordConfirm = (EditText) findViewById(R.id.editPassConfirmReg);
        final EditText editName = (EditText) findViewById(R.id.editNameReg);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String pass = editPassword.getText().toString();
                String pass2 = editPasswordConfirm.getText().toString();

                // add vals to db
                UserDB db = new UserDB(getApplicationContext());
                if(pass.equals(pass2)){

                    //add user
                    User user = new User(1,name,email,pass,"","");
                    db.addUser(user);

                    //go to next screen
                    Intent nextScreen = new Intent(v.getContext(),quiz.class);
                    startActivity(nextScreen);

                }
                else {
                    Toast.makeText(v.getContext(),"Passwords do not match: please try again",3).show();
                    editPassword.setText("");
                    editPasswordConfirm.setText("");

                }




            }
        });


    }






}
