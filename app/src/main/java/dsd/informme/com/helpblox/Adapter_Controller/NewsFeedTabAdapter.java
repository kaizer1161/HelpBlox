package dsd.informme.com.helpblox.Adapter_Controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dsd.informme.com.helpblox.R;
import dsd.informme.com.helpblox.UI_View.NewsFeed;
import dsd.informme.com.helpblox.UI_View.ProfileFragment;

/**
 * Created by kaizer on 12/3/16.
 */

public class NewsFeedTabAdapter extends FragmentPagerAdapter {

    private Context context;

    public NewsFeedTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new NewsFeed();
        }
        else if (position == 1){
            return new NewsFeed();
        }
        else if (position == 2) {
            return new ProfileFragment();
        }
        else {
            return new NewsFeed();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.news);
        }
        else if (position == 1) {
            return context.getString(R.string.trending);
        }
        else {
            return context.getString(R.string.profil);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
