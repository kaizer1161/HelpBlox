package dsd.informme.com.helpblox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by kaizer on 11/24/16.
 */

public class NewsAdapter extends ArrayAdapter<NewsFeed> {

    Context context;

    public NewsAdapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_news_layout, parent, false);

            //gets item position of the current news.
            NewsFeed currentNews = getItem(position);


            // Finding  all the View in activity_news_layout.xml with the ID and
            // assigning them to the corresponding view objects

            ImageView userImage = (ImageView) listItemView.findViewById(R.id.user_imageView_id);
            TextView userName = (TextView) listItemView.findViewById(R.id.news_username_textView_id);
            TextView dateAndTime = (TextView) listItemView.findViewById(R.id.news_date_time_textView_id);
            TextView newsContent = (TextView) listItemView.findViewById(R.id.news_content_textView_id);

            userImage.setImageResource(currentNews.getImageRecourseId());
            userName.setText(currentNews.getUserName());
            dateAndTime.setText(currentNews.getTimeAndDate());
            newsContent.setText(currentNews.getNewsContent());

        }

        return listItemView;
    }
}
