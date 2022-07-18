package IODemo.TransFormation;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//乱码问题引入转换流
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //文件默认按照utf-8的编码方式来读取文件的,如果更改文件格式，那么就会产生乱码，此时引出转换流。
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\advice.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String content;
        content = bufferedReader.readLine();
        System.out.println(content);
    }
}
