package dsd.informme.com.helpblox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kaizer on 11/21/16.
 */

public class CategoryActivity  extends AppCompatActivity {

        ArrayList<String> categoryName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryName.add("Google");
        categoryName.add("Github");
        categoryName.add("Instagram");
        categoryName.add("Facebook");
        categoryName.add("Flickr");
        categoryName.add("Pinterest");
        categoryName.add("Quora");
        categoryName.add("Twitter");
        categoryName.add("Vimeo");
        categoryName.add("WordPress");
        categoryName.add("Youtube");
        categoryName.add("Stumbleupon");
        categoryName.add("SoundCloud");
        categoryName.add("Reddit");
        categoryName.add("Blogger");
        categoryName.add("Google");
        categoryName.add("Github");
        categoryName.add("Instagram");
        categoryName.add("Facebook");
        categoryName.add("Flickr");
        categoryName.add("Pinterest");
        categoryName.add("Quora");
        categoryName.add("Twitter");
        categoryName.add("Vimeo");
        categoryName.add("WordPress");
        categoryName.add("Youtube");
        categoryName.add("Stumbleupon");
        categoryName.add("SoundCloud");
        categoryName.add("Reddit");
        categoryName.add("Blogger");
        categoryName.add("Google");
        categoryName.add("Github");
        categoryName.add("Instagram");
        categoryName.add("Facebook");
        categoryName.add("Flickr");
        categoryName.add("Pinterest");
        categoryName.add("Quora");
        categoryName.add("Twitter");
        categoryName.add("Vimeo");
        categoryName.add("WordPress");
        categoryName.add("Youtube");
        categoryName.add("Stumbleupon");
        categoryName.add("SoundCloud");
        categoryName.add("Reddit");
        categoryName.add("Blogger");
        categoryName.add("Google");
        categoryName.add("Github");
        categoryName.add("Instagram");
        categoryName.add("Facebook");
        categoryName.add("Flickr");
        categoryName.add("Pinterest");
        categoryName.add("Quora");
        categoryName.add("Twitter");
        categoryName.add("Vimeo");
        categoryName.add("WordPress");
        categoryName.add("Youtube");
        categoryName.add("Stumbleupon");
        categoryName.add("SoundCloud");
        categoryName.add("Reddit");
        categoryName.add("Blogger");

        CategoryAdapter adapter = new CategoryAdapter(CategoryActivity.this, categoryName);
        GridView grid = (GridView)findViewById(R.id.category_gridView_id);
        grid.setAdapter(adapter);

    }

}

