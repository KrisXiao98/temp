package IODemo.Demo;

import org.junit.jupiter.api.Test;

import java.io.File;

public class GetFileInformation {
    public static void main(String[] args) {

    }

    //获取文件信息
    @Test
    public void getInfo(){
        File file = new File("D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\a.txt");
        System.out.println("文件名=" + file.getName());
        System.out.println("绝对路径地址=" + file.getAbsolutePath());
        System.out.println(file.getParent());//父目录
        System.out.println(file.length());//按字节
    }
}
