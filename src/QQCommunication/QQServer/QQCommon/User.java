package QQCommunication.QQServer.QQCommon;


import java.io.Serializable;

/*
说明：
1.为什么要定义QQCommon，需求分析图中我们可以看到，客户端和服务端通过我们的一个对象流来进行传输数据。
那么就可以将数据存入对象中互相发送，那么就定义一个共有的
 */
public class User implements Serializable {
    private String useId;
    private String pwd;

    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String useId, String pwd) {
        this.useId = useId;
        this.pwd = pwd;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
