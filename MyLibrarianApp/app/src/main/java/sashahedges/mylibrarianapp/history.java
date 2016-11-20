package sashahedges.mylibrarianapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class history extends AppCompatActivity {

    // HAMBURGER MENU
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button addHistory = (Button) findViewById(R.id.addBookButton);

        LinearLayout myLayout = (LinearLayout) findViewById(R.id.myLayout);

        // get book from db
        DBHandler db = new DBHandler(getApplicationContext());


        // get user from user db
        final AppVars mApp = ((AppVars)getApplicationContext());
        UserDB users = new UserDB(getApplicationContext());
        User user = users.getUser(mApp.getUser());





        if(!users.getUser(mApp.getUser()).getUserBookList().equals("")){
            String[] books = user.getUserBookList().split(" / ");


            for (int i=1;i<books.length;i++){
                final Book bk = db.getBook(books[i]);
                TextView t = new TextView(this);
                t.setText(books[i]);
                t.setTextSize(20);
                t.setPadding(0,50,0,0);
                t.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mApp.setBookName(bk.getTitle());
                                Intent nextScreen = new Intent(v.getContext(),BookPage.class);
                                startActivity(nextScreen);
                            }
                        }

                );
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


        // HAMBURGER MENU
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        addDrawerItems();
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent nextScreen1 = new Intent(view.getContext(), SearchForABookPage.class);
                        startActivity(nextScreen1);
                        break;
                    case 1:
                        Intent nextScreen2 = new Intent(view.getContext(), userProfile.class);
                        startActivity(nextScreen2);
                        break;
                    case 2:
                        Intent nextScreen3 = new Intent(view.getContext(), history.class);
                        startActivity(nextScreen3);
                        break;
                    case 3:
                        Intent nextScreen4 = new Intent(view.getContext(),MainActivity.class);
                        startActivity(nextScreen4);
                        break;
                    case 4:
                        Intent nextScreen5 = new Intent(view.getContext(), Overdrive.class);
                        startActivity(nextScreen5);
                        break;
                    case 5:
                        mApp.setUser(1);
                        Intent nextScreen6 = new Intent(view.getContext(), login.class);
                        startActivity(nextScreen6);
                        break;
                }
            }

        });
        setupDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    //HAMBURGER MENU
    private void addDrawerItems() {
        String[] osArray = {"FIND A BOOK", "User Profile", "Checkout History", "Main", "To Overdrive", "Logout"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }
    private void setupDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
