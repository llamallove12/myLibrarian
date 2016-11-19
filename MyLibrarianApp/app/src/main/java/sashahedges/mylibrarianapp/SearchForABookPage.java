package sashahedges.mylibrarianapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class SearchForABookPage extends AppCompatActivity {

    // HAMBURGER MENU
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_abook_page);

        final RadioButton TitleRB = (RadioButton) findViewById(R.id.TitleRadioButton);
        final RadioButton AuthorRB = (RadioButton) findViewById(R.id.AuthorRadioButton);

        final EditText TitleTB = (EditText) findViewById(R.id.textBox);


        Button search = (Button) findViewById(R.id.searchButton);

        // Book database
        final DBHandler db = new DBHandler(getApplicationContext());


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout bookList = (LinearLayout) findViewById(R.id.listOfBooks);
                TextView t = (TextView) findViewById(R.id.searchBookName);

                final AppVars mApp = ((AppVars)getApplicationContext());
                if (TitleRB.isChecked()){
                    String bookTitle = TitleTB.getText().toString();
                    final Book bk = db.getBook(bookTitle);
                    if(bk==null){
                        t.setText("No Titles Found");
                    }
                    else{
                        t.setText(bk.getTitle());
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
                    }
                }
                else if(AuthorRB.isChecked()){
                    String bookAuthor = TitleTB.getText().toString();
                    final Book bk = db.getBookByAuthor(bookAuthor);
                    if(bk==null){
                        t.setText("No Titles Found");
                    }
                    else{
                        t.setText(bk.getTitle());
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
                    }

                }

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(TitleTB.getWindowToken(),0);



            }
        });


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
