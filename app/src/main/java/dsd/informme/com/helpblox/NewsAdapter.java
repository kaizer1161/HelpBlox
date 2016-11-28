package dsd.informme.com.helpblox;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by kaizer on 11/24/16.
 */

public class NewsAdapter extends ArrayAdapter<NewsFeedContent> {

    public NewsAdapter(Activity context, ArrayList<NewsFeedContent> news) {

        super(context, 0, news);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_news_layout, parent, false);
        }

            //gets item position of the current news.
            NewsFeedContent currentNews = getItem(position);


            // Finding  all the View in activity_news_layout.xml with the ID and
            // assigning them to the corresponding view objects

            ImageView userImage = (ImageView) listItemView.findViewById(R.id.user_imageView_id);
            TextView userName = (TextView) listItemView.findViewById(R.id.news_username_textView_id);
            TextView dateAndTime = (TextView) listItemView.findViewById(R.id.news_date_time_textView_id);
            TextView newsContent = (TextView) listItemView.findViewById(R.id.news_content_textView_id);

            //Corresponding views are populated
            userImage.setImageResource(currentNews.getImageRecourseId());
            userName.setText(currentNews.getUserName());
            dateAndTime.setText(currentNews.getTimeAndDate());
            newsContent.setText(currentNews.getNewsContent());

        return listItemView;
    }
}
