package dsd.informme.com.helpblox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kaizer on 11/21/16.
 */

public class CategoryActivity  extends AppCompatActivity {

    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        nextBtn = (Button) findViewById(R.id.nextToPPicBtn_id);
        ArrayList<String> categoryName = new ArrayList<>();

        categoryName.add("1");
        categoryName.add("2");
        categoryName.add("3");
        categoryName.add("4");
        categoryName.add("5");
        categoryName.add("6");
        categoryName.add("7");
        categoryName.add("8");
        categoryName.add("9");
        categoryName.add("10");
        categoryName.add("11");
        categoryName.add("12");
        categoryName.add("13");
        categoryName.add("14");
        categoryName.add("15");
        categoryName.add("16");
        categoryName.add("17");
        categoryName.add("18");
        categoryName.add("19");
        categoryName.add("20");
        categoryName.add("21");
        categoryName.add("22");
        categoryName.add("23");
        categoryName.add("24");
        categoryName.add("25");
        categoryName.add("26");
        categoryName.add("27");
        categoryName.add("28");
        categoryName.add("29");
        categoryName.add("30");
        categoryName.add("31");
        categoryName.add("32");
        categoryName.add("33");
        categoryName.add("34");
        categoryName.add("35");
        categoryName.add("36");
        categoryName.add("37");
        categoryName.add("38");
        categoryName.add("39");
        categoryName.add("40");
        categoryName.add("41");
        categoryName.add("42");
        categoryName.add("43");
        categoryName.add("44");
        categoryName.add("45");
        categoryName.add("46");
        categoryName.add("47");
        categoryName.add("48");
        categoryName.add("49");
        categoryName.add("50");
        categoryName.add("51");
        categoryName.add("52");
        categoryName.add("53");
        categoryName.add("54");
        categoryName.add("55");
        categoryName.add("56");
        categoryName.add("57");
        categoryName.add("58");
        categoryName.add("59");
        categoryName.add("60");
        categoryName.add("61");
        categoryName.add("62");
        categoryName.add("63");
        categoryName.add("64");
        categoryName.add("65");
        categoryName.add("66");
        categoryName.add("67");
        categoryName.add("68");
        categoryName.add("69");
        categoryName.add("70");

        CategoryAdapter adapter = new CategoryAdapter(CategoryActivity.this, categoryName);
        GridView grid = (GridView) findViewById(R.id.category_gridView_id);
        grid.setAdapter(adapter);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Fetching String from EditText and assigning them to variables.
                //userName = String.valueOf(userEditText.getText());
                //emailId = String.valueOf(userEditText.getText());
                //password = String.valueOf(passwordEditText.getText());
                //reEnteredPassword = String.valueOf(reEnteredPassEditText.getText());

                Intent intent = new Intent(CategoryActivity.this, ProfilePicActivity.class);
                startActivity(intent);
            }
        });

    }

}

