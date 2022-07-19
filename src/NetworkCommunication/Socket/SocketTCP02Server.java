package NetworkCommunication.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    /*
    需求：
    1.编写一个客户端和一个服务端
    2.服务端监听9999端口
    3.客户端连接到服务器端，发出 hello server， 并接收服务器端回发点的hello client。再退出
    4.服务端接收到客户端发出的hello server，并发送 hello client。再退出
    5.如果客户端和服务端不是接收的相应信息 就不退出
     */

    public static void main(String[] args) throws IOException {

        //1.创建ServerSocket对象来监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端开始监听9999端口，正在建立连接。。。。。");

        //2.建立连接成功就返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("服务端与客户端连接成功。。。。");

        //3.等待客户端给服务端发送hello server，如果一直收不到就阻塞在这里
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] arrayBuffer = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(arrayBuffer)) != -1){
            String content = new String(arrayBuffer, 0, readLength);
            if (content.equals("hello server")){
                //发给客户端hello client
                outputStream.write("hello client".getBytes());
                //设置结束标记，说明，我输出流关闭，后面不写东西了
                socket.shutdownOutput();
                System.out.println("发送客户端hello client");
                break;
            }
            System.out.println("服务端接收到的信息：" + content);
        }
        System.out.println("服务端接收到了客户端发出的hello server，退出。。。。。");

        //4.关闭相关资源
        serverSocket.close();
        socket.close();
        inputStream.close();
        outputStream.close();
    }
}
