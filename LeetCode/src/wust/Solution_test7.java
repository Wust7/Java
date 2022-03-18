package wust;

import java.util.Scanner;

public class Solution_test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxMonth = sc.nextInt();
        int maxDay = sc.nextInt();
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        String t = ""+year+month+day;
        StringBuilder sbt = new StringBuilder(t);
        sbt.reverse();
        if(sbt.toString().equals(t)){
            month++;
        }
        String Year = String.valueOf(year);
        day = Year.charAt(0)-'0';
        while(true){
            if(month ==(maxMonth+1)){
                month=1;
                year++;
            }
            String s = ""+year+month+day;
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            if(sb.toString().equals(s)){
                System.out.println(s);
                break;
            }
            month++;
        }
    }
}
