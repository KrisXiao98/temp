package NetworkCommunication.TCPFileCopy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class StreamUtils01Client {
    /*
    需求：
    1.编写一个服务端，和一个客户端
    2.服务器端在9999端口监听
    3.客户端连接到服务端,发送一张图片....
    4.服务器端接收到客户端发送的图片，保存到src下,发送“收到图片”再退出
    5.客户端接收到服务端发送的“收到图片"，再退出
     */
    public static void main(String[] args) throws IOException {
        /*
        需求分析：
        1.发送图片是需要使用字节流传输,可以做成字符流，来提高效率
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 8898);

        String picPath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\TransFormation\\Data\\pic.png";
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        //读二进制文件边读边写会报错，下面的ByteArrayOutputStream是老韩的代码
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(picPath));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] arrayBuffer = new byte[1024];
        int readLength;
        while ((readLength = fileInputStream.read(arrayBuffer)) != -1){
            bos.write(arrayBuffer, 0, readLength);
        }
        bos.close();
        bufferedOutputStream.write(bos.toByteArray());
        socket.shutdownOutput();
        System.out.println("图片输出完毕");

        BufferedReader bufferedReaderClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReaderClient.readLine());

        socket.close();
        fileInputStream.close();
        bufferedOutputStream.close();
        bufferedReaderClient.close();




    }
}
