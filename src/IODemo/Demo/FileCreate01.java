package IODemo.Demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate01 {
    public static void main(String[] args) {

    }

    //方式1，new File(filePath);
    @Test
    public void create01(){
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\a.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }

    //方式2，根据父目录文件+子路径构建
    @Test
    public void create02(){
        //父目录文件
        File parentFile = new File("D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\");
        //子路径构建
        String child = "b.txt";
        File file = new File(parentFile, child);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式3，根据父目录+子路径构建
    @Test
    public void create03(){
        String parent = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\";
        String child = "c.txt";
        File file = new File(parent, child);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
