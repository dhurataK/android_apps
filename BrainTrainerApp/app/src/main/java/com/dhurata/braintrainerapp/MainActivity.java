package com.dhurata.braintrainerapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView sumTextView;
    TextView timer;
    TextView result;
    TextView pointsTextView;
    Button playAgainButton;
    RelativeLayout gameLayout;

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timer.setText("30s");
        pointsTextView.setText("0/0");
        result.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timer.setText("0s");
                result.setText("Your score is "+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();

    }
    public void generateQuestion(){
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();
        int incorrectAnswer;

        for(int i =0; i<4;i++){
            if(i == locationOfCorrectAnswer)
            {
                answers.add(a+b);
            }
            else{
                incorrectAnswer = rand.nextInt(41);

                while(incorrectAnswer == a+b ){
                    incorrectAnswer = rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }
        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));
    }
    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            result.setText("Correct!");
            score++;
        }else {
            result.setText("Wrong!");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestion();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.goBtn);
        sumTextView = (TextView)findViewById(R.id.sum);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);
        timer = (TextView)findViewById(R.id.timer);
        result = (TextView)findViewById(R.id.result);
        pointsTextView = (TextView)findViewById(R.id.score);
        playAgainButton = (Button)findViewById(R.id.playAgainBtn);
        gameLayout = (RelativeLayout)findViewById(R.id.game);


    }
    public void start(View view){

        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainBtn));
    }

}
