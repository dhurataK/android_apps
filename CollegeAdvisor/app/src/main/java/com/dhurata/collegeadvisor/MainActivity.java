package com.dhurata.collegeadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CollegeExpert expert = new CollegeExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindCollege(View view){
        TextView colleges = (TextView)findViewById(R.id.colleges); // reference of TextView
        Spinner subjects = (Spinner)findViewById(R.id.subject_spinner); //
        String subjectType = String.valueOf(subjects.getSelectedItem());

        List<String> subjectsList = expert.getColleges(subjectType);
        StringBuilder collegesFormated = new StringBuilder();
        for(String subject: subjectsList){
            collegesFormated.append(subject).append('\n');
        }
        colleges.setText(collegesFormated);
    }
}
