package wust;

import java.util.Scanner;

public class Solution_test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        long[] nums = new long[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextLong();
        }
        long pre = 0;
        int total = 0;
        for (int i = 0; i < count; i++) {
            long k=0;
            if(nums[i]!=pre){
                k=Math.abs(nums[i] - pre);
                long temp = 0;
                for (long j = 1; j <= k; j++) {
                    temp+=j;
                    if(temp>k){
                        total+=j-1+(k-(temp-j))*2;
                        break;

                    }else if(temp==k){
                        total+=j;
                        break;
                    }

                }
                pre = nums[i];
            }
            System.out.println(total);
        }
    }
}
