package wust;

import java.util.Scanner;

public class Solution_test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int temp = 2;
        for(int i = 0;i<count;i++){
            int fir = sc.nextInt();
            int sec = sc.nextInt();
            Scanner sc2 = new Scanner(System.in);
            String str = sc2.nextLine();
            StringBuilder strRe = new StringBuilder(str);
            String str2 = strRe.reverse().toString();
            String S = str,RS = str2;
            for(int j = 0;j<fir;j++){
                StringBuilder strReS = new StringBuilder(RS);
//                String str2 = strRe.reverse().toString();
                if(S.equals(RS)){
                    temp = 1;
                    break;
                }
                String tempStr = S;
                S =S + RS;
                RS =RS + tempStr;
//                StringBuilder strRe = new StringBuilder(str);
//                String str2 = strRe.reverse().toString();
            }
            System.out.println(temp);
        }
    }
}
