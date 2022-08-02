package Reflection.IntroductionOfReflection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//引入反射
public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Reflection/IntroductionOfReflection/re.properties"));
        String classfullpath = properties.getProperty("classfullpath").toString();
        String methodName = properties.getProperty("method");

        //使用反射
        //1.加载类
        Class cls = Class.forName(classfullpath);
        //2.通过cls对象，得到你加载的类的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());//这里的运行类型还是Cat
        //3.通过 cls 得到你加载的类 Cat 的 methodName 的方法对象
        //即，在反射中，可以把方法视为对象
        Method method = cls.getMethod(methodName);
        //调用cls类的methodName的方法,即通过方法对象来实现调用方法
        method.invoke(o);


    }
}
