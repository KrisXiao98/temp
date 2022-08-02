package QQCommunication.QQClient.QQService;

import QQCommunication.QQClient.QQCommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    //需要持有socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    //为了更方便的得到socket
    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台和服务器通讯，因此我们做成一个while循环来控制
        while (true) {
            try {
                System.out.println("客户端线程，等待从服务器端读取的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //特别重要，如果服务器没有传数据过来，那么就会阻塞在这里
                Message message = (Message) ois.readObject();


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
