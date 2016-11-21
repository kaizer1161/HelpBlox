import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;

import java.util.ArrayList;

import dsd.informme.com.helpblox.R;

/**
 * Created by kaizer on 11/21/16.
 */

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ArrayList<String> category = new ArrayList<>();

        category.add("Blood");
        category.add("Android");
        category.add("iOS");
        category.add("FootBall");


    }

}
