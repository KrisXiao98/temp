package IODemo.BufferWriter;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
使用BufferWriter
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //BufferWriter是处理流
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\a.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        //在new FileWriter(filePath, true)节点流上进行追加选项
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        bufferedWriter.write("我要发财");
        //插入换行符
        //bufferedWriter.write("\n");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("我要发财");

        //说明：关闭外层流即可，传入的FileWriter(filePath) 会在底层关闭
        bufferedWriter.close();
    }
}
