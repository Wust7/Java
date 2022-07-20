package CUG;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class solution_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int k = in.nextInt();
        String a = in.nextLine();
        String str = in.nextLine();
        // 注意 hasNext 和 hasNextLine 的区别
        int fs = k/4;
        int res=0;
        for(int i=0;i<fs;i++){
            char c = str.charAt(len-i-1);
            int temp=0;
            if(c<='9'&&c>='0'){
                temp=c-'0';
            }else{
                temp=c-'A'+10;
            }
            res+=Math.pow(16,i)*temp;
        }
        int sf = k-4*fs;
        char c = str.charAt(len-fs-1);
        int temp=0;
        if(c<='9'&&c>='0'){
            temp=c-'0';
        }else{
            temp=c-'A'+10;
        }
        for(int i =0;i<sf;i++){
            res+=temp%2*Math.pow(2,4*fs+i);
            temp/=2;
        }
        System.out.println(res);
    }
}