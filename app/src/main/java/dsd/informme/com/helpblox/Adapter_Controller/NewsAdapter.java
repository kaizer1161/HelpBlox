package dsd.informme.com.helpblox.Adapter_Controller;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dsd.informme.com.helpblox.R;
import dsd.informme.com.helpblox.data_Model.NewsFeedContent;

/**
 * Created by kaizer on 11/24/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterHolder> {

    LayoutInflater inflater;
    ArrayList<NewsFeedContent> news;

    public NewsAdapter(Activity context, ArrayList<NewsFeedContent> news) {

        inflater = LayoutInflater.from(context);
        this.news = news;

    }

    @Override
    public NewsAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new NewsAdapterHolder(inflater.inflate(R.layout.activity_news_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(NewsAdapterHolder holder, int position) {

        //gets item position of the current news.
        NewsFeedContent item = news.get(position);

        //Corresponding views are populated
        holder.userImage.setImageResource(item.getImageRecourseId());

        //Corresponding views are populated
        holder.userName.setText(item.getUserName());
        holder.dateAndTime.setText(item.getTimeAndDate());
        holder.newsContent.setText(item.getNewsContent());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void itemUpdated(NewsFeedContent[] items) {

        news.clear();
        for (int i = 0; i < items.length; i++)
            news.add(items[i]);

        notifyDataSetChanged();

    }


    class NewsAdapterHolder extends RecyclerView.ViewHolder {

        private View container;
        private ImageView userImage;
        private TextView userName;
        private TextView dateAndTime;
        private TextView newsContent;

        public NewsAdapterHolder(View listItemView) {
            super(listItemView);

            // Finding  all the View in activity_news_layout.xml with the ID and
            // assigning them to the corresponding view objects
            userImage = (ImageView) listItemView.findViewById(R.id.user_imageView_id);
            userName = (TextView) listItemView.findViewById(R.id.news_username_textView_id);
            dateAndTime = (TextView) listItemView.findViewById(R.id.news_date_time_textView_id);
            newsContent = (TextView) listItemView.findViewById(R.id.news_content_textView_id);


        }
    }

}
