package 网络.UDP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //确定主机名称的IP地址。
        InetAddress address = InetAddress.getByName("172.27.111.49");
        //获取此IP地址的主机名
        String name = address.getHostName();
        //返回文本显示中的IP地址字符串
        String ip = address.getHostAddress();

        System.out.println(name+":"+ip);
    }
}
