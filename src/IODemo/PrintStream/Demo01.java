package IODemo.PrintStream;


import java.io.IOException;
import java.io.PrintStream;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //默认情况下，PrintStream输出数据的位置是标准输出即显示器
        PrintStream out = System.out;
        out.print("hello");
        //print底层是使用：write
        /*
        public void print(String s) {
            if (s == null) {
                s = "null";
            }
            write(s);
        }
         */
        //所以我们也可以直接使用write
        out.write("hello, 肖锴".getBytes());

        //修改打印流输出的设备即位置
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\PrintStream.txt";
        /*
        public static void setOut(PrintStream out) {
            checkIO();
            setOut0(out);  // native方法，修改了out
        }
         */
        System.setOut(new PrintStream(filePath));
        System.out.println("测试修改打印流输出的设备即位置");


    }
}
