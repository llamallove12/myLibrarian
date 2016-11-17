package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final EditText editEmail = (EditText) findViewById(R.id.editEmail);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                if(password.equals("password") && email.equals("susan@gmail.com")){
                    Intent nextScreen = new Intent(v.getContext(),MainActivity.class);
                    startActivity(nextScreen);

                }

                else{
                    Toast.makeText(v.getContext(),"Login failed",3).show();
                    editEmail.setText("");
                    editPassword.setText("");
                }
            }
        });
    }
}
