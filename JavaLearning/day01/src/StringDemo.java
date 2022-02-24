import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        for(int i = 0;i<3;i++){
            System.out.println(line.charAt(i));
        }
    }
}
