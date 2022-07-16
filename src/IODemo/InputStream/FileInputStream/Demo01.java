package IODemo.InputStream.FileInputStream;


import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//使用FileInputStream实现读取txt文件，显示到控制台
public class Demo01 {
    public static void main(String[] args) {
    }

    @Test
    public void readFile01(){
        //单个字节读取，效率比较低。
        int readByte;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(
                    "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\b.txt");
            while ( (readByte = fileInputStream.read()) != -1){
                System.out.print((char) readByte);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭文件释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void readFile02(){
        //使用readByte读取提高效率
        int readLength;
        //让一次读取8个字节
        byte[] bytes = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(
                    "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\b.txt");
            //如果读取正常，返回实际读取的字节数,最大是8， 下次读取返回总长度 - 8
            while ( (readLength = fileInputStream.read(bytes)) != -1){
                System.out.println(readLength);
                System.out.println(new String(bytes, 0, readLength));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭文件释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
