package IODemo.TransFormation;


import java.io.*;

//转换流引入
public class Demo02 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\advice.txt";

        //1.把FileInputStream 转为 InputStreamReader。这里 InputStreamReader 是字符流， FileInputStream 是 InputStream的实现类。
        //意思就是用字节流，gbk编码来读取文件
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //2.BufferedReader是处理流，inputStreamReader是Reader的实现类，转为处理流效率更高。
        BufferedReader br = new BufferedReader(inputStreamReader);
        //最终实现通过转换流加指定编码格式的方式，读取字符文件。
        System.out.println(br.readLine());
    }
}
