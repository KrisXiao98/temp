package IODemo.Reader.FileReader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo01 {
    public static void main(String[] args) {

    }

    @Test
    //第一种方法，效率较低，循环读取单个字符
    public void read01(){
        String path =  "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\reader.txt";
        FileReader fileReader = null;
        int fileRead;
        try {
            fileReader = new FileReader(path);
            while ((fileRead = fileReader.read()) != -1){
                System.out.print((char) fileRead);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void read02(){
        //使用读多大的数组来提高效率
        String path =  "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\reader.txt";
        FileReader fileReader = null;
        int fileRead = 0;
        char[] charLength = new char[16];
        try {
            fileReader = new FileReader(path);
            while ((fileRead = fileReader.read(charLength)) != -1){
                System.out.print(new String(charLength, 0, charLength.length));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
