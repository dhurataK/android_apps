package com.dhurata.numbershape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dhurata.numbershape.Numbers;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNumber(View view){
        EditText usersNumber = (EditText)findViewById(R.id.numField);
        String sUserNumber = usersNumber.getText().toString();
        int inputed_num = parseInt(sUserNumber);

        ImageView myImg = (ImageView)findViewById(R.id.squareImg);

        Numbers mynumber = new Numbers();
        mynumber.number = inputed_num;
        String res ="";
        if(mynumber.isTriangular()){
            res = "Triangular";
            myImg.setImageResource(R.drawable.triangel);
            myImg.setVisibility(View.VISIBLE);
        }
        else if(mynumber.isSquare()){
            res ="Square";
            myImg.setImageResource(R.drawable.squarenumbers);
            myImg.setVisibility(View.VISIBLE);
        }
        else{
            res ="is nor a triangle nor a square!";
            myImg.setVisibility(View.INVISIBLE);
        }
        Toast.makeText(getApplicationContext(),"Typed number is "+res,Toast.LENGTH_LONG).show();

    }
}
