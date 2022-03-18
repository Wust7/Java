package wust;

public class Solution_258 {
    public static void main(String[] args) {
        int num = 238541;
        while(num>9){
            num =num - (num/10) * 9 ;
        }
        System.out.println(num);
    }
}
