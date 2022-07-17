package IODemo.ObjectStream;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

//文件反序列化
public class ObjectInputStreamDemo_ {
    public static void main(String[] args) throws Exception {
        String needReadFilePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\data.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(needReadFilePath));

        //1.反序列化读取的顺序，需要和你序列化的顺序一致，否则就会出异常
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readUTF());
        Object o = objectInputStream.readObject();
        System.out.println(o);
        objectInputStream.close();

        //2.特别重要的细节
        /*
        如果想要调用Dog方法，那么需要向下转型,注意这里是否需要引入包，如果访问不到，是无法向下转型的
         */
        Dog dog = (Dog) o;
        System.out.println(dog.getName());
    }
}
