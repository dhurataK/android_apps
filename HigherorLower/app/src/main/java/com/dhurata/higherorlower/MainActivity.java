package com.dhurata.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton(View view){
        EditText typed_number = (EditText)findViewById(R.id.typeField);
        Random randomGenerator = new Random();
        int randNum = randomGenerator.nextInt(20);
        String typed_num_to_str = typed_number.getText().toString();
        String result ="";
        if (!typed_num_to_str.matches("")){
            int parsed_typed_num = Integer.parseInt(typed_num_to_str);
            if(randNum> parsed_typed_num){
                result = "Higher";
            }
            else if(randNum<parsed_typed_num){
                result = "Lower";
            }
            else {
                result ="You've got it!";
            }
        }else{
            result = "You must type a number!";
        }

        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
    }
}
