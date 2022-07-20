package NetworkCommunication.Socket;

import CodeBlock.B;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello client");
        //另一个结束时标记
        bufferedWriter.newLine();//这里必须需要对方readline的方式来读取
        //必须加 如果使用字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();//必须按顺序
        //socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println("服务端接收到的信息：" + readLine);
        }

        socket.close();
        serverSocket.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
