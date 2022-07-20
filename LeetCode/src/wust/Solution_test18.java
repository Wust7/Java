package wust;

import java.util.Scanner;

public class Solution_test18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long count =0;
        int a=0;//横
        while(a <= n/k){
            int b=n-a*k;//竖
            if(a==0||b==0){
                count++;
            }else{
                long a_j = jiecheng(a);
                long b_j = jiecheng(b);
                long a_b_j=jiecheng(a+b);
                count=(count+a_b_j/(a_j*b_j))%998244353;
            }
            a++;
        }
        System.out.println(count);

    }
    public static long jiecheng(int num){
        long res =1;
        for (int i = 1; i <= num; i++) {
            res*=i;
        }
        return res;
    }
}
