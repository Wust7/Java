package wust.touzi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_test5 {
    static class touzi{
        int a1,a2,b1,b2,c1,c2;
        touzi(int[] nums){
            a1=nums[0];a2=nums[1];b1=nums[2];b2=nums[3];c1=nums[4];c2=nums[5];
        }
        public boolean isTrue(touzi a){
            Map<Integer,Integer> map=new HashMap<>();
            map.put(a1,a2);map.put(b1,b2);map.put(c1,c2);
            map.put(a2,a1);map.put(b2,b1);map.put(c2,c1);
            if(map.get(a.a1)!=a.a2||map.get(a.b1)!=a.b2||map.get(a.c1)!=a.c2){
                return false;
            }
            return true;
        }
        public boolean equals(Object obj){
            touzi a = (touzi) obj;
            if(a.a1==a1&&a.b1==b1&&a.c1==c1){
                return  true;
            }
            return false;
        }
        public void qian(){
            int temp=c1;
            c1=a1;a1=c2;c2=a2;a2=temp;
        }
        public void hou(){
            int temp=c2;
            c2=a1;a1=c1;c1=a2;a2=temp;
        }
        public void zuo(){
            int temp=b1;
            b1=a1;a1=b2;b2=a2;a2=temp;
        }
        public void you(){
            int temp=b2;
            b2=a1;a1=b1;b1=a2;a2=temp;
        }


    }
    public static int ans=99;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int count =0;count<n;count++){
            int[] nums1=new int[6];
            int[] nums2=new int[6];
            for(int i = 0 ;i<6;i++){
                nums1[i]=scanner.nextInt();
            }
            for(int i = 0 ;i<6;i++){
                nums2[i]=scanner.nextInt();
            }

            touzi temp1 = new touzi(nums1);
            touzi temp2 = new touzi(nums2);
            if(!temp1.isTrue(temp2)){
                System.out.println(-1);
                continue;
            }
            ans = 99;
            if(temp1.equals(temp2))
                System.out.println(0);
            else{
                backtrack(temp1,temp2,0,0);
            }
            System.out.println(ans);
        }
    }
    public static void backtrack(touzi a,touzi b,int flag,int res){
        if(res>12)
            return;
        if(a.equals(b)){
            ans=Math.min(res,ans);
            return;
        }
        for(int i=1;i<=4;i++){
            if(i == 1){
                a.qian();
                backtrack(a,b,i,res+1);
                a.hou();
            }
            else if(i==2){
                a.hou();
                backtrack(a,b,i,res+1);
                a.qian();
            }
            else if(i==3){
                a.zuo();
                backtrack(a,b,i,res+1);
                a.you();
            }
            else{
                a.you();
                backtrack(a,b,i,res+1);
                a.zuo();
            }

                }
            }

        }

