package wust;

import java.util.Scanner;

public class Solution_test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = 0;
        for (int i = 2; i < s.length(); i++) {
            if(s.charAt(i)=='1' || s.charAt(i)=='2'|| s.charAt(i)=='4'|| s.charAt(i)=='8'){
                num+=1;
            } else if(s.charAt(i)=='3'|| s.charAt(i)=='5'|| s.charAt(i)=='6'|| s.charAt(i)=='9'|| s.charAt(i)=='a'|| s.charAt(i)=='c'){
                num+=2;
            } else if(s.charAt(i)=='7'|| s.charAt(i)=='b'|| s.charAt(i)=='d'|| s.charAt(i)=='e'){
                num+=3;
            } else if(s.charAt(i)=='f'){
                num+=4;
            }
        }
        System.out.println(num);
    }
}
