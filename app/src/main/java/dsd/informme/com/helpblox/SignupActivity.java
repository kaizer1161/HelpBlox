package dsd.informme.com.helpblox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;

import java.util.ArrayList;

import dsd.informme.com.helpblox.R;

/**
 * Created by kaizer on 11/21/16.
 */

public class SignupActivity extends AppCompatActivity {

    /*
     * All Variables are declared here.
     */

    Button nextBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nextBtn = (Button) findViewById(R.id.nextToCategoryBtn_id);

        //click listener for (Next) Button. clicking this Button makes intent for CategoryActivity.
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(SignupActivity.this, CategoryActivity.class);
                startActivity(categoryIntent);
            }
        });

    }

}