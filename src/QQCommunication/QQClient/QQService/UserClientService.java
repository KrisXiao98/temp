package QQCommunication.QQClient.QQService;


import QQCommunication.QQClient.QQCommon.Message;
import QQCommunication.QQClient.QQCommon.MessageType;
import QQCommunication.QQClient.QQCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

//用户登录验证和注册等功能
public class UserClientService {

    private User u = new User();
    private Socket socket;

    public boolean checkUser(String userID, String pwd){
        boolean res = false;
        //创建User对象
        u.setUseId(userID);
        u.setPwd(pwd);

        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //发送user对象
            oos.writeObject(u);
            //从服务器读取回复的mes对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            //判断服务器中是否含有这个用户
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //创建一个线程来和服务端通讯-》创建一个线程类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //为了后面客户端的扩展，我们将线程放在一个集合中来
                ManageClientConnectServerThread.addClientConnectServerThread(userID, clientConnectServerThread);
                res = true;

            }else {
                //登录失败，我们就不能启动和服务器通讯的线程，但是socket还是创建着的
                socket.close();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }


}
