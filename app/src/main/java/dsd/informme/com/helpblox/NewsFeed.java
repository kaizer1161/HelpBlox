package dsd.informme.com.helpblox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kaizer on 12/3/16.
 */
public class NewsFeed extends Fragment {

    public NewsFeed(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_news_feed_layout, container, false);

        //arraylist for feed
        ArrayList<NewsFeedContent> news = new ArrayList<>();

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Mir Rayan", "Oct 16, 05:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Proma", "Nov 16, 10:54am", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Fhamida", "Jan 24, 02:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated. This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated. This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Zubi", "july 24, 08:12am", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Mir Rayan", "Oct 16, 05:54pm", "This is a place holder content, to check if the layout is working properly. When database will be added, contents for this layout will be auto generated."));

        NewsAdapter newsAdapter = new NewsAdapter(getActivity(), news);
        ListView listView = (ListView) rootView.findViewById(R.id.newsView_newsFeed_ListView_id);
        listView.setAdapter(newsAdapter);

        return rootView;
    }
}
