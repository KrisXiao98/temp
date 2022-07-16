package IODemo.OutPutStream.FileOutPutStream;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


//使用FileOutPutStream在d.txt文件中写入hello world,如果文件不存在，就创建文件。
public class Demo01 {
    public static void main(String[] args) {

    }

    @Test
    public void createFile01() {
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\d.txt";
        File file = new File(filePath);
        if (!(file.exists())) {
            try {
                file.createNewFile();
                System.out.println(filePath + "文件创建完成");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);//这种创建方式是覆盖
            fileOutputStream.write("hello world".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void createFile02() {
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\d.txt";
        File file = new File(filePath);
        if (!(file.exists())) {
            try {
                file.createNewFile();
                System.out.println(filePath + "文件创建完成");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath,true);//这种创建方式是追加
            fileOutputStream.write("hello world".getBytes(), 0, 5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
