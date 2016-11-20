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
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class userProfile extends AppCompatActivity {

    // HAMBURGER MENU
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        final Button quizButton = (Button) findViewById(R.id.recommendationQuizButton);     // recommendation button
        final Button editProfileButton = (Button) findViewById(R.id.changeUserInfoButton);  // change user profile button
        final TextView nameDisplay = (TextView) findViewById(R.id.name);                    // displays the default user name
        final TextView emailDisplay = (TextView) findViewById(R.id.textView3);              // displays the default user email
        

        AppVars mApp = ((AppVars)getApplicationContext());
        int userID = mApp.getUser();

        final UserDB users = new UserDB(getApplicationContext());
        final User user = users.getUser(userID);


        nameDisplay.setText(user.getUserName());   // displays the user's actual name
        emailDisplay.setText(user.getUserEmail()); // displays the user's actual email

        quizButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextScreen = new Intent(v.getContext(),FirstQuizPage.class);
                        startActivity(nextScreen);
                    }
                }
        );

        editProfileButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextScreen = new Intent(v.getContext(),editUserInfo.class);
                        startActivity(nextScreen);
                    }
                }
        );

        // HAMBURGER MENU
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        addDrawerItems();
        setupDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    //HAMBURGER MENU
    private void addDrawerItems() {
        String[] osArray = {"FIND A BOOK", "User Profile", "Checkout History", "Main", "To Overdrive"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

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
                        // Placeholder
                        Intent nextScreen5 = new Intent(view.getContext(), userProfile.class);
                        startActivity(nextScreen5);
                        break;
                }
            }

        });
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
