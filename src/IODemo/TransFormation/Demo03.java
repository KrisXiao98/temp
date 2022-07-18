package IODemo.TransFormation;


import java.io.*;

//按照指定编码方式保存文件
public class Demo03 {
    public static void main(String[] args) throws IOException {

        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\outputStreamWriter.txt";
        BufferedWriter gbk = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "gbk"));
        gbk.write("q123我要发财");
        gbk.close();
    }
}
