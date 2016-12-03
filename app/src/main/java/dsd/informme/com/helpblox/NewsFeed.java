package dsd.informme.com.helpblox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class NewsFeed extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /////////////////////////////////////////////////////////////////////////////////////
        //arraylist for feed
        ArrayList<NewsFeedContent> news = new ArrayList<>();

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Mir Rayan", "Oct 16, 05:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Proma", "Nov 16, 10:54am", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Fhamida", "Jan 24, 02:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated. This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated. This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Zubi", "july 24, 08:12am", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Mir Rayan", "Oct 16, 05:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        NewsAdapter newsAdapter = new NewsAdapter(NewsFeed.this, news);
        ListView listView = (ListView) findViewById(R.id.newsView_newsFeed_ListView_id);
        listView.setAdapter(newsAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_newsFeed_id) {
            // Handle the camera action
        } else if (id == R.id.nav_category_id) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_settings_id) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
