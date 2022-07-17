package IODemo.ObjectStream;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//演示ObjectOutStream的序列化，如何使用
public class ObjectOutStream {
    public static void main(String[] args) throws Exception {
        //注意，这里文件的格式，可以是任意的格式，你也可以写成文本格式。
        //但是保存完了之后，即序列化后，保存的文件格式，不是纯文本格式，而是按照它的格式来保存，所以即使你写成txt，保存的也不是文本格式的
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\data.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据
        objectOutputStream.writeInt(100); //自动装箱Integer (而Integer实现了Serializable）
        objectOutputStream.writeBoolean(true);//Boolen也是实现了Serializable
        objectOutputStream.writeUTF("肖锴"); //同理

        //保存一个dog对象
        objectOutputStream.writeObject(new Dog("Saber", 10));

        //关闭资源
        objectOutputStream.close();
        System.out.println("序列化形式保存完毕");

    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    //serialVersionUID 序列化的版本号，提高兼容性，不会因为你再加了个hobby就认为是个全新的类。认为是y原先Dog的升级版
    private static final long serialVersionUID = 1L;
    private String hobby;

    //序列化对象时，默认将里面所以属性都进行了序列化，但除了Static或者transient修饰的成员
    //可以看到反序列化输出时，会显示null
    private static String favouriteFood;
    private transient String favouriteWear;

    //要求里面的属性的类型也需要实现序列化接口
    private Master master;//看下面的Master类

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//class Master {}////这里Master没有实现Serializable接口，所以会抛出Serializable异常
class Master implements Serializable{}//必须这么写