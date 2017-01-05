package dsd.informme.com.helpblox.UI_View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import dsd.informme.com.helpblox.R;

/**
 * Created by kaizer on 11/21/16.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    * All Variables are declared here
    */
    public static final String LOGIN_URL = "http://test.artefactplus.com/login.php";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD="password";

    Button loginBtn, newAccountBtn;
    String email, password, username;
    EditText idEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //see if the user is logged in shared memory
        //then redirect to dashboard
        if(getSharedPreferences("informme", 0).getBoolean("isLoggedIn", false)){
            Intent intent = new Intent(this, DashBoard.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_login);

        //Attaching all the widgets to their corresponding view id.
        loginBtn = (Button) findViewById(R.id.loginBtn_id);
        newAccountBtn = (Button) findViewById(R.id.newAccountBtn_id);
        idEditText = (EditText) findViewById(R.id.usernameEditText_id);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText_id);

        loginBtn.setOnClickListener(this);
        //click listener for (create new Account) Button. clicking this Button makes intent for SignupActivity.
        newAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newAccountIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(newAccountIntent);
            }
        });

    }

    private void userLogin() {
        email = idEditText.getText().toString().trim();
        password = passwordEditText.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            SharedPreferences sp = getSharedPreferences("informme", 0);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putBoolean("isLoggedIn", true);
                            editor.apply();
                            openProfile();
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Invalid email ID or Password",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_EMAIL,email);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this, DashBoard.class);
        saveUserEmail();
        startActivity(intent);
    }

    //This method saves user Email address on SharedPreference, for later use on other activity.
    private void saveUserEmail(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    @Override
    public void onClick(View view) {
        userLogin();
    }
}
