package 网络.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
//        //Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号
////        Socket s = new Socket(InetAddress.getByName("172.27.111.49"), 957);
//
//        // Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号
//        Socket s = new Socket("172.27.111.49", 957);
//
//
//        //返回此套接字的输出流
//        OutputStream os = s.getOutputStream();
//        //发送数据
//        os.write("hello world".getBytes());
//
//        //接收服务器反馈
//        InputStream is = s.getInputStream();
//        byte[] bys = new byte[1024];
//        int len = is.read(bys);
//        System.out.println("客户端："+new String(bys,0,len));
//
//        //释放资源
//        s.close();

        client();

    }

    private static void client()throws IOException {
        // Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号
        Socket s = new Socket("172.27.111.49", 957);

//        读取文本文件数据
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
//        键盘录入数据
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while((line=br.readLine())!=null){
//            if("886".equals(line)){
//                break;
//            }
//            //获取输出流对象
//            OutputStream os = s.getOutputStream();
//            os.write(line.getBytes());
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
////        自定义结束标记
////        文件中可能有该标记，会出现文件读取中断
//        bw.write("886");
//        bw.newLine();
//        bw.flush();

//        接收反
//        禁用此套接字的输出流。 对于TCP套接字，任何先前写入的数据将被发送，随后是TCP的正常连接终止序列。
//        如果在套接字上调用shutdownOutput（）之后写入套接字输出流，则流将抛出IOException
//        返回结束标记
        s.shutdownOutput();

        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("服务器反馈："+brClient.readLine());
        br.close();
        s.close();
    }
}
