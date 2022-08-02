package QQCommunication.QQServer.Service;

import QQCommunication.QQServer.QQCommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userID;//客户端连接到服务端的userID

    public ServerConnectClientThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    @Override
    public void run() {
        //线程运行，可以接收和发送消息
        while (true){
            try {
                System.out.println("服务端和客户" + userID + "端保持通讯，读取数据.....");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
