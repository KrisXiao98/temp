package IODemo.Exercise;

import java.io.File;
import java.io.IOException;

public class Exercise03 {
    public static void main(String[] args) throws IOException {
        /*
        需求：
        判断是否存在文件夹xxx，不存在就创建文件夹
        在该文件夹下，创建test.txt文件
        如果存在该文件，提示文件已经存在，不要重复创建
         */
        String dicPath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Exercise\\Data";
        File file = new File(dicPath);
        if (file.exists() == false){
            System.out.println("需要创建文件夹");
            file.mkdirs();
            System.out.println("创建文件夹就成功");
        }
        String fileName = "test.txt";
        File file1 = new File(dicPath, fileName);
        if (file1.exists() == false){
            file1.createNewFile();
            System.out.println("文件不存在，创建成功");
        }else {
            System.out.println("文件已经存在");
        }
    }
}
