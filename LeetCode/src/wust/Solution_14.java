package wust;

public class Solution_14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String temp = strs[0];
        for(int i = 1;i < strs.length;i++){
            int minLength = Math.min(temp.length(), strs[i].length());
            int count = 0;
            while(count<minLength && temp.charAt(count) == strs[i].charAt(count)){
                count++;
            }
            temp = temp.substring(0,count);
        }
        System.out.println(temp);
    }
}
