package wust;

public class Solution_537 {
    public static void main(String[] args) {
        String num1 = "1+-1i", num2 = "1+-1i";
        String[] list1 = num1.split("\\+");
        String[] list2 = num2.split("\\+");
        String[] list3 = list1[1].split("i");
        String[] list4 = list2[1].split("i");
        int a = Integer.valueOf(list1[0]);
        int b = Integer.valueOf(list3[0]);
        int c = Integer.valueOf(list2[0]);
        int d = Integer.valueOf(list4[0]);
        System.out.println((a*c-b*d)+""+(a*d+b*c)+"i");
    }

}
