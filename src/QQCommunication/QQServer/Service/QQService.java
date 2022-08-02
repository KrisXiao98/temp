package QQCommunication.QQServer.Service;


import QQCommunication.QQClient.QQCommon.Message;
import QQCommunication.QQClient.QQService.ManageClientConnectServerThread;
import QQCommunication.QQServer.QQCommon.MessageType;
import QQCommunication.QQServer.QQCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端监听9999端口，等待客户端的连接并保持通讯
public class QQService {

    private ServerSocket ss = null;

    public QQService() {
        try {
            System.out.println("服务端在9999端口监听。。。。");
            ss = new ServerSocket(9999);
            while (true){//当和某个客户端建立连接后，会继续监听，因此while循环
                Socket socket = ss.accept();
                //得到socket对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//读取到的是一个User对象
                //创建Message对象，用来返回
                Message message = new Message();
                if (u.getUseId().equals("100") && u.getPwd().equals("123456")){
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //回复成功
                    oos.writeObject(message);
                    //创建线程，和客户端保持通讯，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUseId());
                    serverConnectClientThread.start();//启动线程
                    //线程对象放在集合中进行管理
                    ManageServerThreads.addServerThread(u.getUseId(), serverConnectClientThread);

                }else {//失败返回
                    message.setMesType(MessageType.MESSAGE_LOGIN_FINAL);
                    oos.writeObject(message);
                    //关闭
                    socket.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //如果服务端退出了while循环，说明服务端不再监听。因此需要关闭资源
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
