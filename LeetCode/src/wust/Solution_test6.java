package wust;

import java.util.Scanner;

public class Solution_test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxMonth = sc.nextInt();
        int maxDay = sc.nextInt();
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int count = 100000;
        while(count>0){
            day++;
            if(day ==(maxDay+1)){
                day=1;
                month++;
            }
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
            count--;
        }
    }
}
