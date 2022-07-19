package NetworkCommunication.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class SocketTCP02Client {
    /*
    需求：
    1.编写一个客户端和一个服务端
    2.服务端监听9999端口
    3.客户端连接到服务器端，发生 hello server， 并接收服务器端回发点的hello client。再退出
    4.服务端接收到客户端发出的hello server，并发送 hello client。再退出
    5.如果客户端和服务端不是接收的相应信息 就不退出
     */

    public static void main(String[] args) throws IOException {
        //这里就是客户端连接上服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端建立通信。。。");

        //发送数据给客户端
        String[] content = {"Kris", "XIxi", "hello server", "end"};
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        for (String strContent : content) {
            outputStream.write(strContent.getBytes());
        }
        //设置结束标记，说明，我输出流关闭，后面不写东西了
        socket.shutdownOutput();

        //接收来自服务端的数据
        byte[] arrayBuffer = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(arrayBuffer)) != -1) {
            String res = new String(arrayBuffer, 0, readLength);
            if (res.equals("hello client")) {
                break;
            }
            System.out.println("客户端接收到的信息：" + content);
        }

        socket.close();
        outputStream.close();
        inputStream.close();
        System.out.println("关闭");


    }
}
