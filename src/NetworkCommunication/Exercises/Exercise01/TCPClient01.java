package NetworkCommunication.Exercises.Exercise01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient01 {
    /*
    需求：
    (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
    (2)客户端发送"name"，服务器端接收到后，返回“我是nova ", nova是你自己的名字.
    (3)客户端发送"hobby"，服务器端接收到后，返回“编写java程序"
    (4)不是这两个问题，回复“你说啥呢”
     */
    public static void main(String[] args) throws IOException {
        //客户端起到接收和发出数据的作用
        Socket socket = new Socket(InetAddress.getLocalHost(), 8848);

        //字符输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("name");
        bufferedWriter.write("hobby");
        bufferedWriter.write("Kris");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        //接收收到的字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String content;
        while ((content = bufferedReader.readLine()) != null) {
            System.out.println("得到服务端输入内容：" + content);
        }


        //关闭资源
        socket.close();
        bufferedWriter.close();
        bufferedReader.close();

    }
}
