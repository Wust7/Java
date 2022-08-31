package 网络.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
//        //创建绑定到指定端口的服务器套接字
//        ServerSocket ss = new ServerSocket(957);
//
////        侦听要连接到此套接字并接受它
//        Socket s = ss.accept();
//
//        //获取输入流，读数据
//        InputStream is = s.getInputStream();
//        byte[] bys = new byte[1024];
//        int len = is.read(bys);
//        String data = new String(bys, 0, len);
//        System.out.println("数据是："+data);
//
//        //给出反馈
//        OutputStream os = s.getOutputStream();
//        os.write("数据收到".getBytes());
////        s.close();
//        //释放ss，is和os也会自动释放
//        ss.close();
        multiThreadServer();
    }

//    private static void server()throws IOException {
////        创建绑定到指定端口的服务器套接字
//        ServerSocket ss = new ServerSocket(957);
//
////        侦听要连接到此套接字并接受它
//        Socket s = ss.accept();
//
////        获取输入流
//        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
////        封装接收到的数据
//        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
//        String line;
//        while((line= br.readLine())!=null){
////            s.shutdownOutput();执行之后不再需要判断结束标记
////            if("886".equals(line)){
////                break;
////            }
//            System.out.println(line);
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
//        }
////        给出反馈
//        BufferedWriter bwserver = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        bwserver.write("文件上传成功");
//        bwserver.newLine();
//        bwserver.flush();
//        //先关bw
//        bw.close();
//        ss.close();
//    }
    private static void multiThreadServer()throws IOException {
    //        创建绑定到指定端口的服务器套接字
        ServerSocket ss = new ServerSocket(957);

        while(true){
            //侦听要连接到此套接字并接受它
            Socket s = ss.accept();
            new Thread(new ServerThread(s)).start();
        }

    }
}
