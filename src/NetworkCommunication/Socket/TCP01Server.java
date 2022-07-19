package NetworkCommunication.Socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//写服务端
public class TCP01Server {
    public static void main(String[] args) throws IOException {
        /*
        服务端：
        1.需求：实现接收客户端的消息，并打印到屏幕上
        2.在本机的9999端口进行监听，并等待链接
        3.当没有客户端链接9999端口时，程序会阻塞，等待链接
        4.socket.getInputStream进行接收数据
         */

        //1.创建ServerSocket对象，对9999端口进行监听
        /*
        细节：
        1.如果9999端口已经被占用，那么就会报错
        2.ServerSocket可以创建很多socket，他只要建立了链接，他就会返回一个Socket。
          因为程序可能有很多Socket，实现多并发。
        3.ServerSocket可以通过accept方法，返回多个Socket[多个客户端连接服务器的Socket对象]
         */
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("客户端监听已经开启，试图与客户端的9999端口进行连接。。。。。");

        //2.如果serverSocket的接收方法，发现连接到了9999端口，那么就返回一个Socket对象
        /*
        细节
        1.如果没有连接到这个9999端口，那么就会阻塞在这里一直等待连接
         */
        Socket socket = serverSocket.accept();
        System.out.println("服务端已经连接到客户端的到9999端口。。。。。");

        //3.通过服务端自己的InputStream 节点流的字符输入流的方法接收数据;
        /*
        细节
        如果这里客户端一直都没有输出数据流到数据通道，那么，这里也会阻塞。
         */
        InputStream inputStream = socket.getInputStream();
        byte[] arrayBuffer = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(arrayBuffer)) != -1){
            System.out.println(new String(arrayBuffer, 0, readLength));
        }

        //4.关闭相关资源
        serverSocket.close();
        socket.close();
        inputStream.close();

    }
}
