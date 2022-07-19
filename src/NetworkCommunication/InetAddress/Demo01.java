package NetworkCommunication.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01 {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress host1 = InetAddress.getLocalHost();
        System.out.println(host1);

        //根据指定的主机名，和获取 InetAddress 对象
        InetAddress host2 = InetAddress.getByName("LAPTOP-12CK1D2A");
        System.out.println(host2);

        //根据域名获取InetAddress对象
        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println(host3);

        //通过InetAddress对象，获取对应的地址
        String host2Address = host2.getHostAddress();
        System.out.println(host2Address);

        //通过InetAddress对象，获取对应的主机或者域名
        String host3Address = host3.getHostName();
        System.out.println(host3Address);
    }
}
