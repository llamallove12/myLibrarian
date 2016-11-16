package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Alexandra on 11/16/2016.
 */

public class LoginPage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final EditText editLogin = (EditText) findViewById(R.id.editLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editLogin.getText().toString();
                if(password.equals("ou812")){
                    Intent nextScreen = new Intent(v.getContext(),MainActivity.class);
                    startActivity(nextScreen);

                }

                else{
                    Toast.makeText(v.getContext(),"Login failed",3).show();
                    editLogin.setText("");
                }
            }
        });
    }

}
