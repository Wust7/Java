import org.junit.Test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class t1 {
//    public static void main(String[] args) {
////        int[] nums={2,1,-2,3};
////        int target =5;
////        System.out.println(closestNumber(nums,target));
////        int W=3;
////        int[][] R={{0,1,600},{1,2,800},{0,2,1300}};
////        System.out.println(test(W,R,0,2));
////        test();
//        System.out.println(isIpv6Address("2001:db8:2de:0:0:0:0:e13"));
//        System.out.println(isIpv6Address("10.168.13.29"));
//        System.out.println(isIpv6Address(null));
//        String address="";
//        try {
//            final InetAddress inetAddress = InetAddress.getByName(address);
//            if(inetAddress instanceof Inet4Address){
//                System.out.println("IPv4");
//            }else if(inetAddress instanceof Inet6Address){
//                System.out.println("IPv6");
//            }
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//    }
//    public static int closestNumber(int[] nums, int target){
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length-i-1; j++) {
//                if(nums[j]<nums[j+1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                }
//            }
//        }
//        int res=0;
//        int cha=0;
//        for (int i = 0; i < nums.length-2; i++) {
//            int temp=nums[i]+nums[i+1]+nums[i+2];
//            if(Math.abs(temp-cha)<target){
//                res=temp;
//            }
//
//        }
//        return res;
//    }
//    public static int test(int W,int[][]R,int A,int B){
////        ArrayList<HashMap<Integer,Integer>> map = new ArrayList<>();
////        for (int i = 0; i < W; i++) {
////            map.add(new HashMap<>());
////        }
////        for (int i = 0; i < R.length; i++) {
////            map.get(R[i][0]).put(R[i][1],R[i][2]);
////        }
////        int res=0;
////        for (int i = 0; i < map.get(A).size(); i++) {
////            map.get(A).get(i)
////        }
//        int[][] weight =new int[W][W];
//        for (int i = 0; i < R.length; i++) {
//            weight[R[i][0]][R[i][1]] = R[i][2];
//        }
//        int res = Dijsktra(weight, A,B);
//        return res;
//
//    }
//
//    public static int Dijsktra(int[][] weight,int start,int end){
//        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
//        //返回一个int[] 数组，表示从start到它的最短路径长度
//        int n = weight.length;        //顶点个数
//        int[] shortPath = new int[n];    //存放从start到其他各点的最短路径
//        String[] path=new String[n]; //存放从start到其他各点的最短路径的字符串表示
//        for(int i=0;i<n;i++)
//            path[i]=new String(start+"-->"+i);
//        int[] visited = new int[n];   //标记当前该顶点的最短路径是否已经求出,1表示已求出
//
//        //初始化，第一个顶点求出
//        shortPath[start] = 0;
//        visited[start] = 1;
//
//        for(int count = 1;count <= n - 1;count++)  //要加入n-1个顶点
//        {
//
//            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
//            int dmin = Integer.MAX_VALUE;
//            for(int i = 0;i < n;i++)
//            {
//                if(visited[i] == 0 && weight[start][i] < dmin)
//                {
//                    dmin = weight[start][i];
//
//                    k = i;
//                }
//
//            }
//            System.out.println("k="+k);
//
//            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
//            shortPath[k] = dmin;
//
//            visited[k] = 1;
//
//            //以k为中间点，修正从start到未访问各点的距离
//            for(int i = 0;i < n;i++)
//            {                 // System.out.println("k="+k);
//                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
//                    weight[start][i] = weight[start][k] + weight[k][i];
//
//                    path[i]=path[k]+"-->"+i;
//
//                }
//
//            }
//
//        }
//
//        return shortPath[end];
//    }
//
//    public static boolean isIpv6Address(String address) {
//        try {
//            final InetAddress inetAddress = InetAddress.getByName(address);
//            return inetAddress instanceof Inet6Address;
//        } catch (UnknownHostException e) {
//            return false;
//        }
//    }
    public static void main(String[] args) {
        System.out.println(solve("02001:db8:2de:0:0:0:0:e13"));
    }
    public static String solve(String ip){
        try {
            final InetAddress inetAddress = InetAddress.getByName(ip);
            if(inetAddress instanceof Inet4Address){
                return "IPv4";
            }else if(inetAddress instanceof Inet6Address){
                return "IPv6";
            }
        } catch (UnknownHostException e) {
            return null;
        }
        return null;
    }

}
