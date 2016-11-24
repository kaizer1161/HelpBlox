package dsd.informme.com.helpblox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<NewsFeed> news = new ArrayList<>();

        news.add(new NewsFeed(R.mipmap.ic_launcher, "Mir Rayan", "Oct 16, 05:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeed(R.mipmap.ic_launcher, "Proma", "Nov 16, 10:54am", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeed(R.mipmap.ic_launcher, "Fhamida", "Jan 24, 02:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated. This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated. This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeed(R.mipmap.ic_launcher, "Zubi", "july 24, 08:12am", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, news);
        ListView listView = (ListView) findViewById(R.id.newsView_newsFeed_ListView_id);
        listView.setAdapter(newsAdapter);

    }
}
