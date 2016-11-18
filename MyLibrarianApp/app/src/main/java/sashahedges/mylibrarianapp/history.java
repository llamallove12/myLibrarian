package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button addHistory = (Button) findViewById(R.id.addBookButton);

        LinearLayout myLayout = (LinearLayout) findViewById(R.id.myLayout);

        // get book from db
        DBHandler db = new DBHandler(getApplicationContext());


        // get user from user db
        AppVars mApp = ((AppVars)getApplicationContext());
        UserDB users = new UserDB(getApplicationContext());
        User user = users.getUser(mApp.getUser());


        if(!users.getUser(mApp.getUser()).getUserBookList().equals("")){
            Toast.makeText(this,users.getUser(mApp.getUser()).getUserBookList()+"  "+user.getUserName(),Toast.LENGTH_LONG).show();
            String[] books = user.getUserBookList().split(" / ");
            for (String s : books){
                TextView t = new TextView(this);
                t.setText(s);
                myLayout.addView(t);
            }

        }
        else{
            Toast.makeText(this,"here: "+user.getUserBookList()+"  "+user.getUserName(),Toast.LENGTH_LONG).show();

        }



        addHistory.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // go to history page
                        //Toast.makeText(v.getContext(),user.getUserBookList(),Toast.LENGTH_LONG).show();
                        Intent nextScreen = new Intent(v.getContext(),addHistoryBook.class);
                        startActivity(nextScreen);


                    }
                }
        );


    }
}
