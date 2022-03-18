package wust;

import org.junit.Test;

import java.util.*;


public class Solution_test13 {

//    @Test
//    public void test2() {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(s);
//        int[][] graph = new int[][]{{0, 0, 0, 0, 0},
//                                    {0, 0, 1, 1, 0},
//                                    {0, 0, 2, 0, 0},
//                                    {0, 0, 1, 0, 0}};
//
////        计算（[0][0]到[2][3]的最短路径，1是障碍物）
//        int[] start = {0, 0};
//        int[] end = {2, 2};
//        System.out.println(shortestStep(graph, start, end));
////        v.add("0234");
////        System.out.println(v.contains(String.valueOf(0)+String.valueOf(234-1+1)));
//
//    }
//    @

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        for (int i = 0; i < group; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            Map<Integer,String> youjun = new HashMap<>();
            for (int pi = 0; pi < A; pi++) {
                youjun.put(pi,"");
            }
            String[] graph = new String[N];
            Map<Integer,Integer> dijun = new HashMap<>();
            int[][] graphNum = new int[N][M];
            for (int j = 0; j < N; j++) {
                String temp = sc.nextLine();
                graph[j] = sc.nextLine();
                for (int k = 0; k < M; k++) {
                    if(graph[j].charAt(k)=='+'){
                        graphNum[j][k] =0;
                    } else if(graph[j].charAt(k)=='W'){
                        graphNum[j][k] =1;
                    } else if(graph[j].charAt(k)=='E'){
                        dijun.put(j,k);
                        graphNum[j][k] =2;
                    } else{
                        youjun.replace((graph[j].charAt(k)-'0'),j+" "+k);
                        graphNum[j][k] =0;
                    }
                }
            }

            System.out.println(graphNum);
        }
    }

    public static int shortestStep(int[][] g, int[] start, int[] end) {
        if(start[0]==end[0]&&start[1]==end[1])
            return 0;
        int ylen = g.length, xlen = g[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited=new boolean[ylen][xlen];
        queue.offer(new int[]{start[0],start[1],1});
//        使用队列先进先出
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[1], y = pos[0];
            visited[y][x]=true;
            System.out.println(Arrays.toString(pos));
//          左
            if (x - 1 >= 0 && g[y][x - 1] != 1 && !visited[y][x-1])
            {
                if (y == end[0] && x - 1 == end[1]) return pos[2];
                else queue.offer(new int[]{y, x - 1, pos[2] + 1});
            }
//          右
            if (x + 1 < xlen && g[y][x + 1] != 1 && !visited[y][x+1]) {
                if (y == end[0] && x + 1 == end[1]) return pos[2];
                else queue.offer(new int[]{y, x + 1,pos[2]+1});
            }
//          上
            if (y - 1 >= 0 && g[y - 1][x] != 1 && !visited[y-1][x]){
                if (y - 1 == end[0] && x == end[1]) return pos[2];
                else queue.offer(new int[]{y - 1, x,pos[2]+1});}
//          下
            if (y + 1 < ylen && g[y + 1][x] != 1 && !visited[y+1][x]) {
                if (y + 1 == end[0] && x == end[1]) return pos[2];
                else queue.offer(new int[]{y + 1, x, pos[2] + 1});
            }
        }
//        代表不可达
        return -1;
    }

}
