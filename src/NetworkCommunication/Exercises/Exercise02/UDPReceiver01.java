package NetworkCommunication.Exercises.Exercise02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver01 {
    /*
    需求：
    (1)编写一个接收端A,和一个发送端B，使用UDP协议完成
    (2)接收端在8888端口等待接收数据(receive)
    (3)发送端向接收端发送数据“四大名著是哪些"
    (4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>>..."，否则返回what?
    (5)接收端和发送端程序退出
     */
    public static void main(String[] args) throws IOException {
        //5656端口作为接收端口
        DatagramSocket datagramSocket = new DatagramSocket(5656);

        //输出，需要装包
        byte[] buffArray = "四大名著是：《红楼梦》《西游记》《水浒传》《三国演义》".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(buffArray, buffArray.length, InetAddress.getLocalHost(), 5657);

        //接收数据
        byte[] buf = new byte[1024];
        DatagramPacket acceptPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(acceptPacket);
        //packet对象拆包
        int length = acceptPacket.getLength();//实际接收到的数据字节长度
        byte[] data = acceptPacket.getData();
        String s = new String(data, 0, length);
        System.out.println("接收端接收到的数据：" + s);
        if (s.equals("四大名著是什么")){
            datagramSocket.send(sendPacket);
        }

    }
}
