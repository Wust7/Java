package 网络.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
//        DatagramSocket ds = new DatagramSocket(10086);
//        //DatagramPacket(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包
//        byte[] bys = new byte[1024];
//        DatagramPacket dp = new DatagramPacket(bys, bys.length);
//
//        //不能放在这个地方，因为此处dp还没有接收数据，len就已经给赋1024了
////        int len = dp.getLength();
//        //接收数据
//        ds.receive(dp);
//
////        //解析数据：返回数据缓冲区
////        byte[] datas = dp.getData();
////        //返回要发送的数据的长度或接收到的数据的长度
////        int len = dp.getLength();
////
////        String dataString = new String(datas,0,len);
////        System.out.println("数据："+dataString);
//
//        //上面的等价于
//        System.out.println("数据："+new String(dp.getData(),0,dp.getLength()));
//        ds.close();
        DatagramSocket ds = new DatagramSocket(1234);

        while(true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            ds.receive(dp);
            System.out.println("数据是：" + new String(dp.getData(), 0, dp.getLength()));
        }
        //关闭数据
//        ds.close();
    }
}
