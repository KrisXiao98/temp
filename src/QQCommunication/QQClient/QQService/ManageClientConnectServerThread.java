package QQCommunication.QQClient.QQService;


import java.util.HashMap;

//管理客户端连接到服务器端的线程的类
//老师是创建的类来管理，我当时想的是直接
public class ManageClientConnectServerThread {

    //将多个线程放入一个HashMap集合，key为用户id，value为客户端连接服务器端的线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //将线程放入集合
    public static void addClientConnectServerThread(String userID, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userID, clientConnectServerThread);

    }

    //通过userid，可以得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userID){
        return hm.get(userID);
    }


}
