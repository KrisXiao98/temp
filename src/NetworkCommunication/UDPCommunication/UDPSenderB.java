package NetworkCommunication.UDPCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderB {
    /*
    需求：
    1.编写一个接收端A和一个发送端B
    2.接收端A在9999端口等待接收数据（receive）
    3.发送端B向接收端A发送Hello World
    4.接收端A收到发送端B的数据，回复Ok。再退出
    5.发送端接收回复的数据，再退出
     */
    public static void main(String[] args) throws IOException {
        //构建DatagramSocket对象，在9998端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        byte[] data = "Hello World".getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9999);
        datagramSocket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();//实际接收到的数据字节长度
        byte[] res = datagramPacket.getData();
        String s = new String(res, 0, length);
        System.out.println(s);


        datagramSocket.close();

    }

}
