package dsd.informme.com.helpblox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kaizer on 11/21/16.
 */

public class LoginActivity extends AppCompatActivity {

    /*
    * All Variables are declared here
    */

    Button loginBtn, newAccountBtn;
    String userName, Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn_id);
        newAccountBtn = (Button) findViewById(R.id.newAccountBtn_id);

        //click listener for login Button. clicking Login Button makes intent for MainActivity.
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });

        //click listener for (create new Account) Button. clicking this Button makes intent for SignupActivity.
        newAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newAccountIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(newAccountIntent);
            }
        });

    }
}
