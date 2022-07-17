package IODemo.Exercise;


import java.io.*;

//使用处理流对文件进行拷贝
public class Exercise02 {
    public static void main(String[] args) throws IOException {
        //要拷贝的文件地址
        String needCopyFilePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\BufferedReader.txt";
        //往哪里拷贝
        String aimFilePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\CopyTest.txt";
        //文件不存在就会自动创建
        //处理流拷贝
        BufferedReader bufferedReader = new BufferedReader(new FileReader(needCopyFilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(aimFilePath));
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null){
            bufferedWriter.write(readLine);
            //手动加入换行
            bufferedWriter.newLine();
        }
        System.out.println("拷贝完成");
        bufferedReader.close();
        bufferedWriter.close();
    }
}
