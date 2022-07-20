package NetworkCommunication.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    /*
    需求：
    1.请使用字符流
    2.同SocketTCP02Server需求一样
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello server");
        //另一个结束时标记
        bufferedWriter.newLine();//这里需要对方readline的方式来读取
        //必须加 如果使用字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();//必须按顺序
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println("客户端接收到的信息：" + readLine);
        }

        socket.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
