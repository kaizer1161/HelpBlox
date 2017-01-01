package dsd.informme.com.helpblox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kaizer on 1/1/17.
 */

public class ProfileFragment extends android.support.v4.app.Fragment {

    public ProfileFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //TextView textView;
        View rootView = inflater.inflate(R.layout.dash_board_post_bar, container, false);



        return rootView;

    }
}
