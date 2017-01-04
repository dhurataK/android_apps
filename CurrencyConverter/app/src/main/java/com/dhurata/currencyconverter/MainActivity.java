package com.dhurata.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickFunction(View view){
        EditText amount = (EditText)findViewById(R.id.amountField);
        String sAmount = amount.getText().toString();
        double a = new Double(sAmount).doubleValue();
        double euro = 0.94;
        double exchanged =a*euro;
        Toast.makeText(getApplicationContext(),"Your amount in euro: "+exchanged,Toast.LENGTH_LONG).show();
    }
}
