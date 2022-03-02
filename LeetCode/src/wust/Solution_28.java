package wust;

public class Solution_28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int k = haystack.length() - needle.length() + 1;
        for(int i = 0; i < k; i++){
            for(int j = 0;j < needle.length();j++){
                if(haystack.charAt(i+j) !=needle.charAt(j)){
                    break;
                }else if(j == needle.length()-1){
                    System.out.println(i);
                }
            }
        }
        System.out.println(-1);
    }
}
