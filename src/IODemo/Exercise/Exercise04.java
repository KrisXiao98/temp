package IODemo.Exercise;

import Object.HomeWork.HomeWork13.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise04 {
    public static void main(String[] args) throws IOException {
        /*
        需求：
        使用bufferedReader读取一个文件，为每行加上行号，再连同内容一并输出到屏幕上
         */
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Exercise\\Data\\Exercise04.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //加上行号
        String readLine = null;
        int countLine = 0;
        while ((readLine = bufferedReader.readLine()) != null){
            countLine++;
            System.out.println("行号：" + countLine + "内容：" + readLine);
        }
    }
}
