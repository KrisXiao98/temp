package NetworkCommunication.Socket;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//写客户端
public class TCP01Client {
    /*
    客户端
    1.链接服务端（IP，端口）
    2.连接上后，生成socket，通过getOuputStream进行输出
    3.通过输出流，写入数据到数据通道
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        System.out.println("客户端成功连接上服务端。。。。");

        OutputStream outputStream = socket.getOutputStream();
        //将想要传入数据通道的信息写进去
        outputStream.write("简单实现客户端和服务端的Socket通信。。。。".getBytes());

        //关闭资源
        socket.close();
        outputStream.close();
    }


}
