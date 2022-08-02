package QQCommunication.QQServer.Service;

import java.util.HashMap;

//管理服务端和客户端通讯的线程
public class ManageServerThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //添加线程对象
    public static void addServerThread(String userID, ServerConnectClientThread serverConnectClientThread){
        hm.put(userID, serverConnectClientThread);
    }

    //根据userID返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userID){
        return hm.get(userID);
    }


}
