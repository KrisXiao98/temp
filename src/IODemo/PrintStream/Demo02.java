package IODemo.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Demo02 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\PrintWriter.txt";
        PrintWriter gbk = new PrintWriter(filePath);
        gbk.write("测试PrintWriter");
        gbk.close();
    }
}
