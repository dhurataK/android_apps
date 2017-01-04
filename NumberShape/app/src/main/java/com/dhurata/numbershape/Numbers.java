package com.dhurata.numbershape;

/**
 * Created by Dell-pc on 12/15/2016.
 */

public class Numbers {
    public int number;

    public boolean isTriangular(){
        int x = 1;
        int triangularNumber = 1;

        while (triangularNumber < number){
            x++;
            triangularNumber += x;
        }
        return triangularNumber == number;
    }
    public boolean isSquare(){
        double squareRoot = Math.sqrt(number);
        return squareRoot == Math.floor(squareRoot);
    }

}
