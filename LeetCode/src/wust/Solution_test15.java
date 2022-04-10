package wust;

import java.util.Scanner;

public class Solution_test15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int begin_0 = 0;
        int end_0 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (begin_0 == 0 && str.charAt(i) == '0') {
                begin_0 = i + 1;
            }
            if (begin_0 != 0 && str.charAt(i) == '0') {
                end_0 = i + 1;
            }
        }
        int begin_1 = 0;
        int end_1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (begin_1 == 0 && str.charAt(i) == '1') {
                begin_1 = i + 1;
            }
            if (begin_1 != 0 && str.charAt(i) == '1') {
                end_1 = i + 1;
            }
        }
        if (end_0 - begin_0 >= end_1 - begin_1) {
            System.out.println(begin_0 + " " + (end_0 - 1) + " " + (begin_0 + 1) + " " + end_0);
        } else {
            System.out.println(begin_1 + " " + (end_1 - 1) + " " + (begin_1 + 1) + " " + end_1);
        }
    }
}
