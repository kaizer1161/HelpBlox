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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dsd.informme.com.helpblox.R;

/**
 * Created by kaizer on 11/21/16.
 * Database work done by xubi on 12/12/16.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    /*
     * All Variables are declared here.
     */
    private static final String REGISTER_URL = "http://test.artefactplus.com/index.php";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";

    Button nextBtn;
    String userName, emailId, password, reEnteredPassword;
    EditText userEditText, emailEditText, passwordEditText, reEnteredPassEditText;
    RequestQueue requestQueue;
    //String insertURL = "http://test.artefactplus.com/index.php";
    //String showURL = "http://test.artefactplus.com/show.php";


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
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        nextBtn.setOnClickListener(this);
        //click listener for (Next) Button. clicking this Button makes intent for CategoryActivity.
//        nextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Fetching String from EditText and assigning them to variables.
//                userName = String.valueOf(userEditText.getText());
//                emailId = String.valueOf(userEditText.getText());
//                password = String.valueOf(passwordEditText.getText());
//                reEnteredPassword = String.valueOf(reEnteredPassEditText.getText());
//                Intent categoryIntent = new Intent(SignupActivity.this, CategoryActivity.class);
//                startActivity(categoryIntent);
//            }
//        });

    }

    private void registerUser(){
        final String username = userEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();
        final String email = emailEditText.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SignupActivity.this,"Successfully Registered",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignupActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == nextBtn){
            registerUser();
            Intent categoryIntent = new Intent(SignupActivity.this, CategoryActivity.class);
            startActivity(categoryIntent);
        }
    }
}