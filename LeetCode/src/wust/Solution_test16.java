package wust;

import org.junit.Test;

import java.util.Scanner;

public class Solution_test16 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("\\{","");
        s = s.replaceAll("\\}","");
        System.out.println(s);
        String[] numS = s.split(",");
        int[] nums = new int[numS.length-1];
        for (int i = 0; i < numS.length-1; i++) {
            nums[i] = Integer.parseInt(numS[i]);
        }
        int t = Integer.parseInt(numS[numS.length-1]);
        int[] numP = new int[numS.length-1];
        numP = nums;
        //{0,1,2,4,4,4,5,6,6,7},0
        test2(nums,0,t);
        test2(nums,t,nums.length);
        test2(nums,0,nums.length);
        for (int i = 0; i < numP.length; i++) {
            if(numP[i]!=nums[i]){
                System.out.println(false);
                break;
            }

        }
        System.out.println(true);
    }
    public  static void test2(int[] num,int begin,int end){
        for (int i = begin; i < (begin+end)/2; i++) {
            int temp = num[i];
            num[i] = num[end-1-i+begin];
            num[end-1-i+begin] = temp;
        }
    }
}
