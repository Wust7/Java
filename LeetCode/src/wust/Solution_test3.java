package wust;

import java.util.Scanner;

public class Solution_test3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        for(int i = 0;i<num;i++){
//            int max = 0;
//            int A = sc.nextInt();
//            int B = sc.nextInt();
//            int C = sc.nextInt();
//            int D = sc.nextInt();
//            //处理D
//            max +=D;
//
//            //处理C
//            int temp1 = 0;
//            if(A>=C){
//                max += C;
//                temp1 = A-C;
//            } else{
//                max += A;
//            }
//            //处理B
//            max +=B/2;
//            int temp2 = B -B/2*2;
//            max+=(temp1+temp2)/4;
//            System.out.println(max);
//        }
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        int coun1A=0;
        int coun2A=0;
        int diff=0;
        for(int i=0;i<str1.length();i++)
        {
            if (str1.charAt(i) != str2.charAt(i)) {

                diff++;
            }
            if(str1.charAt(i)=='A')
            {
                coun1A+=1;
            }

            if(str2.charAt(i)=='A')
            {
                coun2A+=1;
            }

        }
        int num=0;
        num+=Math.abs(coun1A-coun2A);
        num+=(diff-num)/2;
        System.out.println(num);

    }
}
