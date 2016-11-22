package dsd.informme.com.helpblox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
    String userName, emailId, password, reEnteredPassword;
    EditText userEditText, emailEditText, passwordEditText, reEnteredPassEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Attaching all widgets to their corresponding viewID;
        nextBtn = (Button) findViewById(R.id.nextToCategoryBtn_id);
        userEditText = (EditText) findViewById(R.id.Signup_Username_EditText_id);
        emailEditText = (EditText) findViewById(R.id.Signup_Email_EditText_id);
        passwordEditText = (EditText) findViewById(R.id.Signup_Password_EditText_id);
        reEnteredPassEditText = (EditText) findViewById(R.id.Signup_Password_ReEnter_EditText_id);


        //click listener for (Next) Button. clicking this Button makes intent for CategoryActivity.
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Fetching String from EditText and assigning them to variables.
                userName = String.valueOf(userEditText.getText());
                emailId = String.valueOf(userEditText.getText());
                password = String.valueOf(passwordEditText.getText());
                reEnteredPassword = String.valueOf(reEnteredPassEditText.getText());

                Intent categoryIntent = new Intent(SignupActivity.this, CategoryActivity.class);
                startActivity(categoryIntent);
            }
        });

    }

}