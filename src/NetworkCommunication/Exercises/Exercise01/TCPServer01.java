package NetworkCommunication.Exercises.Exercise01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer01 {
    /*
    需求：
    (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
    (2)客户端发送"name"，服务器端接收到后，返回“我是nova ", nova是你自己的名字.
    (3)客户端发送"hobby"，服务器端接收到后，返回“编写java程序"
    (4)不是这两个问题，回复“你说啥呢”
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8848);

        System.out.println("尝试与客户端连接1------");
        Socket socket = serverSocket.accept();

        //字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String content = bufferedReader.readLine();
        System.out.println("得到客户端输入内容：" + content);
        if (content.equals("name")) {
            bufferedWriter.write("我是nova");
        } else if (content.equals("hobby")) {
            bufferedWriter.write("编写java程序");
        } else {
            bufferedWriter.write("你说啥呢");
        }
        bufferedWriter.newLine();
        bufferedWriter.flush();


        //关闭
        serverSocket.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
