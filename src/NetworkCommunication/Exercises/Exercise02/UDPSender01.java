package NetworkCommunication.Exercises.Exercise02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSender01 {
    public static void main(String[] args) throws IOException {
        //5656端口作为接收端口
        DatagramSocket datagramSocket = new DatagramSocket(5657);

        //输出，需要装包
        byte[] buffArray = "四大名著是什么".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(buffArray, buffArray.length, InetAddress.getLocalHost(), 5656);
        datagramSocket.send(sendPacket);

        //接收数据
        byte[] buf = new byte[1024];
        DatagramPacket acceptPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(acceptPacket);
        //packet对象拆包
        int length = acceptPacket.getLength();//实际接收到的数据字节长度
        byte[] data = acceptPacket.getData();
        String s = new String(data, 0, length);
        System.out.println("发送端接收到的数据：" + s);

    }
}
