package wust;

import java.util.*;

/**
 * 美团
 */
public class Solution_test2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String line0 = sc.nextLine();
        String[] first = line0.split(" ");
        int n =Integer.parseInt(first[0]);
        int m =Integer.parseInt(first[1]);
        String line = sc.nextLine();
        String[] endNum = line.split(" ");
        int count =100;
        while(count >0){
            List<String> ls = Arrays.asList(endNum);
            Collections.shuffle(ls);
            endNum =ls.toArray(new String[ls.size()]);
            int end =0;
            for(int i =0;i<m;i++){
                String line2 = sc.nextLine();
                String[] nums = line2.split(" ");
                if(nums[0].equals("1")){
                    int num =0;
                    for(int j = Integer.parseInt(nums[1])-1;j<Integer.parseInt(nums[2]);j++){
                        num+=Integer.parseInt(endNum[j]);
                    }
                    end+=num;
                }
                if(nums[0].equals("2")){
                    for(int j = Integer.parseInt(nums[1])-1;j<Integer.parseInt(nums[2]);j++){
                        int a =Integer.parseInt(endNum[j])+Integer.parseInt(nums[3]);
                        endNum[j] =String.valueOf(a);
                    }
                }
            }
            System.out.println(end);
        }
        count--;
    }
}
