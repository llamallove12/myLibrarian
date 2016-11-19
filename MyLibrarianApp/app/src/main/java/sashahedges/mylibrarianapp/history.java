package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
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
            Toast.makeText(this,""+books.length,Toast.LENGTH_LONG).show();

            for (int i=1;i<books.length;i++){
                Book bk = db.getBook(books[i]);
                TextView t = new TextView(this);
                t.setText(books[i]);
                t.setTextSize(20);
                t.setPadding(0,50,0,0);
                myLayout.addView(t);

                RelativeLayout rLayout = new RelativeLayout(this);


                RatingBar r = new RatingBar(this,null,R.attr.ratingBarStyleSmall);
                //r.setNumStars(5);
                r.setRating(bk.getRating());
                //r.setRating(Float.parseFloat("5.0"));
                rLayout.addView(r);
                myLayout.addView(rLayout);
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
