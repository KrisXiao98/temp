package IODemo.Exercise;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//完成文件
public class Exercise01 {
    public static void main(String[] args) {

    }

    @Test
    public void copyFile() throws IOException {
        //完成文件的拷贝
        //需要被拷贝的文件path
        String needCopyFilePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\b.txt";
        //拷贝后的文件path
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\testCopy.txt";
        //如何拷贝？边读边写
        FileInputStream fileInputStream = new FileInputStream(needCopyFilePath);
        //判断拷贝后的文件是否存在
        File file = new File(filePath);
        if (!(file.exists())){
            file.createNewFile();
        }
        int readSign;
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        while ((readSign = fileInputStream.read()) != -1){
            System.out.println((char) readSign);
            fileOutputStream.write(readSign);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
