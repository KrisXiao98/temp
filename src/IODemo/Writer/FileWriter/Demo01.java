package IODemo.Writer.FileWriter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) {

    }

    @Test
    public void fileWriter01(){
        //将要想发财，就别打工 写进advice.txt中
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Demo\\Data\\advice.txt";
        File file = new File(filePath);
        if (file.exists() == false){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);//覆盖模式
            //fileWriter = new FileWriter(filePath,true);//追加模式
            fileWriter.write("要想发财 就别打工");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
