package wust;

public class Solution_9 {

    public static void main(String[] args) {
        int x = 1121;
        if(x<0)
            System.out.println("false");
        String S = String.valueOf(x);
        int j = 0;
        while(j<S.length()/2){
            if(S.charAt(j) != S.charAt(S.length()-j-1)){
                System.out.println("false");
                break;
            }
            j++;

        }
        System.out.println("true");

    }

}
