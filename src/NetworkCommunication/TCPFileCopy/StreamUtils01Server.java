package NetworkCommunication.TCPFileCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamUtils01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8898);
        Socket socket = serverSocket.accept();

        String picPath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\TransFormation\\Data\\pic2.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(picPath));
        byte[] arrayBuffer = new byte[1024];
        int readLength;
        while ((readLength = bufferedInputStream.read(arrayBuffer)) != -1){
            fileOutputStream.write(arrayBuffer);
        }
        System.out.println("图片接收完毕---");

        //输出收到图片
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("收到图片--");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        serverSocket.close();
        bufferedWriter.close();
        bufferedInputStream.close();
        fileOutputStream.close();
        socket.close();
    }
}
