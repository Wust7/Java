package com.item;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        double P[][] = {{1, 2, 3}, {4, 6, 3}, {8, 6, 4}};
        ArrayList<Double> randNum = demo_2.getRX(P);
        for (double i : randNum){
            System.out.println(i);
        }
    }
}
