package IODemo.BufferedReader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
演示BufferedReader
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\BufferedReader.txt";

        //new FileReader(filePath) 这里就是节点流，BufferedReader是处理流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取
        /*
        1.bufferedReader.readLine() 表示每次读取1行
        2.当返回null时，即表示读取完毕了
         */
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        //关闭流，这里注意，只需要关闭BufferedReader，因为底层会自动关闭节点流
        bufferedReader.close();
    }
}
