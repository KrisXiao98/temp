package IODemo.Exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Exercise05 {
    public static void main(String[] args) throws IOException {
        /*
        需求：
        (1)要编写一个dog.properties
        name=tom
        age=5
        color=red
        (2)编写Dog类(name,age,color)创建一个dog对象，读取dog.properties 用相应的内容完成属性初始化.并输出
         */
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Exercise\\Data\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);

        properties.clear();

    }
}

class Dog{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

