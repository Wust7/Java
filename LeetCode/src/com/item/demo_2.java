package com.item;

import java.util.ArrayList;
import java.util.Collections;

public class demo_2 {
    public static ArrayList<Double> getRX(double P[][]) {
//            int gen = 0;
//            for(gen=1;gen<maxGen;gen++){
        int numn = P.length;
        int i = 1;
        ArrayList<Double> randNum = new ArrayList<>();
        while (i <= numn) {
            randNum.add((double) i);
        }
        Collections.shuffle(randNum);
//        }
        return randNum;

    }
}
