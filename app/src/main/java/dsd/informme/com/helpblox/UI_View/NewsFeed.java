package dsd.informme.com.helpblox.UI_View;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import dsd.informme.com.helpblox.Adapter_Controller.NewsAdapter;
import dsd.informme.com.helpblox.R;
import dsd.informme.com.helpblox.data_Model.NewsFeedContent;


/**
 * Created by kaizer on 12/3/16.
 */
public class NewsFeed extends Fragment {

    public static final String DATA_URL = "http://test.artefactplus.com/newsfeed.php";
    public static final String JSON_ARRAY = "users";
    public static String USER_NAME = "username";
    public static String STATUS_TIME = "date_time";
    public static String STATUS = "content";
    public static String IMAGE = "name";

    private NewsAdapter newsAdapter;

    public NewsFeed() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        getStatus();
    }

    private void getStatus() {

        FetchStatus status = new FetchStatus();
        status.execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //TextView textView;
        View rootView = inflater.inflate(R.layout.activity_news_feed_layout, container, false);

        ArrayList<NewsFeedContent> news = new ArrayList<>();

        news.add(new NewsFeedContent(R.mipmap.ic_launcher, "Mir Rayan", "Oct 16, 05:54pm", "This is a place holder content."));

        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.divider);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.newsView_newsFeed_ListView_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter(getActivity(), news);
        recyclerView.setAdapter(newsAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        return rootView;
    }


    class FetchStatus extends AsyncTask<String, Void, NewsFeedContent[]> {


        public FetchStatus() {
            super();
        }

        @Override
        protected NewsFeedContent[] doInBackground(String... params) {


            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String statusStr = null;


            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast

                Uri builtUri = Uri.parse(DATA_URL).buildUpon()
                        .build();

                URL url = new URL(builtUri.toString());

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                statusStr = buffer.toString();

            } catch (IOException e) {
                Log.e("ForecastFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("ForecastFragment", "Error closing stream", e);
                    }
                }

                try {
                    return statusValue(statusStr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
            return null;
        }

        private NewsFeedContent[] statusValue(String response) throws JSONException {

            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(JSON_ARRAY);

            NewsFeedContent[] nfc = new NewsFeedContent[result.length()];

            for (int i = 0; i < result.length(); i++) {

                JSONObject json = result.getJSONObject(i);

                nfc[i] = new NewsFeedContent(R.mipmap.ic_launcher, json.optString(USER_NAME), json.optString(STATUS_TIME), json.optString(STATUS));

            }

            return nfc;

        }

        @Override
        protected void onPostExecute(NewsFeedContent[] result) {

            if (result != null) {
                newsAdapter.itemUpdated(result);
            }

        }
    }


}



