package wust;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            String B = String.valueOf(b);
            long total = 0;
            for (int j = 0; j < B.length(); j++) {
                total+=a*(B.charAt(j)-'0');
            }
            System.out.println(total);
        }

    }
}
