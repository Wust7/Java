package System;

import java.util.Collections;
import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        //创建对象
        Scanner sc = new Scanner(System.in);
        //接收数据
//        String line = sc.nextLine();
//        String line2 = sc.nextLine();
//        System.out.println(line2);

        Scanner sc2 =new Scanner(System.in);
        String line3 = sc2.nextLine();
        String[] endNum = line3.split(" ");
        String line4 = sc2.nextLine();
        System.out.println(line4);
    }
}
