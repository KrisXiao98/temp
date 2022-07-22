package NetworkCommunication.UDPCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    /*
    需求：
    1.编写一个接收端A和一个发送端B
    2.接收端A在9999端口等待接收数据（receive）
    3.发送端B向接收端A发送Hello World
    4.接收端A收到发送端B的数据，回复Ok。再退出
    5.发送端接收回复的数据，再退出
     */

    public static void main(String[] args) throws IOException {
        //构建DatagramSocket对象，在9999端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //如何接收?用DatagramPacket对象
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //调用接收方法，将通过网络传输的DatagramPacket对象填充到packet对象
        //如果没有数据包过来，就会阻塞
        datagramSocket.receive(datagramPacket);

        //packet对象拆包
        int length = datagramPacket.getLength();//实际接收到的数据字节长度
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        byte[] res = "Ok".getBytes();

        DatagramPacket packet = new DatagramPacket(res, res.length, InetAddress.getByName("127.0.0.1"), 9998);
        datagramSocket.send(packet);

        //关闭资源
        datagramSocket.close();

    }

}
