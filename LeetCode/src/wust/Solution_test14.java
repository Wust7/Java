package wust;

import java.util.Scanner;

public class Solution_test14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int M = in.nextInt();
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }
        int[][] S = new int[N][N];
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < N; q++) {
                S[p][q]=array[p][q];
            }
        }
        int[][] preArray = new int[N][N];
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < N; q++) {
                preArray[p][q]=array[p][q];
            }
        }
        //求S
        for (int i = 2; i <= K; i++) {
            preArray=jiecheng(preArray,array);
            for (int j = 0; j < N; j++) {
                for (int p = 0; p < N; p++) {
                    S[j][p] += preArray[j][p];
                }
            }
        }
        //求模
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                S[i][j]%=M;
//            }
//        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(S[i][j]+" ");
            }
            System.out.println();
        }
    }
//    public static int[][] jiecheng(int[][]array,int k){
//        int N = array.length;
//        int[][] preArray = new int[N][N];
//        int[][] tempArray = new int[N][N];
//        preArray = array;
//        for (int totalK = 0; totalK < k-1; totalK++) {
//            for (int i = 0; i <N; i++) {//行
//                for (int j = 0; j < N; j++) {//列
//                    int temp = 0;
//                    for (int p = 0; p < N; p++) {
//                        temp+=preArray[i][p]*array[j][p];
//                    }
//                    tempArray[i][j] = temp;
//                }
//            }
//            for (int i1 = 0; i1 < N; i1++) {
//                for (int i2 = 0; i2 < N; i2++) {
//                    preArray[i1][i2] = tempArray[i1][i2];
//                }
//            }
//        }
//
//        return preArray;
//    }
    public static int[][] jiecheng(int[][]a,int[][]b){
        int N = a.length;
        int[][] c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j]=0;
                for (int k = 0; k < N; k++) {
                    c[i][j]=c[i][j]+a[i][k]*b[k][j];
                }
            }
        }
        return c;
        
    }
}
