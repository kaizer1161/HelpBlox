package dsd.informme.com.helpblox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;


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
    EditText userEditText, emailEditText, passwordEditText, reEnteredPassEditText;
    RequestQueue requestQueue;


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

    }

    private void registerUser(final String username, final String password, final String email, final String rePass) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SignupActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
                        startActivity(i);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (username.equals(null) || email.equals(null) || password.equals(null) || rePass.equals(null)) {
                            Toast.makeText(SignupActivity.this, "Have to Fill All the Info Dude", Toast.LENGTH_LONG).show();
                        }
                        else if(!password.equals(rePass)){
                            Toast.makeText(SignupActivity.this, "Password Doesn't Match", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(SignupActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                        }
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_EMAIL, email);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if (v == nextBtn) {

            String username = userEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String rePass = reEnteredPassEditText.getText().toString().trim();

            if((username.equals(null)) || (password.equals(null)) || (email.equals(null)) || (rePass.equals(null)))
                registerUser(username, password, email, rePass);

            else
                Toast.makeText(SignupActivity.this, "Have to Fill All the Info Dude", Toast.LENGTH_LONG).show();
        }

    }
}