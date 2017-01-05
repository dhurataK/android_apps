package com.dhurata.collegeadvisor;
import java.util.ArrayList;
import java.util.List;

public class CollegeExpert {
    List<String> getColleges(String subject){
        List<String> colleges = new ArrayList<String>();
        if(subject.equals("code")){
            colleges.add("FSHMN");
            colleges.add("FIEK");
            colleges.add("UBT");
        }
        else if(subject.equals("accounting")){
            colleges.add("Ekonomi");
        }
        else{
            colleges.add("Art");
        }
        return colleges;
    }
}
