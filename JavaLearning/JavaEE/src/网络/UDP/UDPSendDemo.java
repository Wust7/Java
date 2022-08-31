package 网络.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
//        //构造数据报套接字并将其绑定到本地主机上的任何可用端口
//        DatagramSocket ds = new DatagramSocket();
//
//
//        byte[] bys = "hello 中国".getBytes();
//        int len = bys.length;
//        InetAddress address = InetAddress.getByName("172.27.111.49");
//        int port = 10086;//(0-655535)
//
//        //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
//        // 构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号
////        DatagramPacket dp = new DatagramPacket(bys, len, address, port);
//        //等价于
//        DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("172.27.111.49"), 10086);
//        //从此套接字发送数据报包
//        ds.send(dp);
//
//        //关闭此数据报套接字
//        ds.close();
        send();
    }

    private static void send() throws IOException {
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine())!=null){
            if("886".equals(line)){
                break;
            }
            byte[] bys = line.getBytes();
            //数据打包
            DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("172.27.111.49"),1234);

            //发送数据
            ds.send(dp);

        }
        ds.close();
    }

}
