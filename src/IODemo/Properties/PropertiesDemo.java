package IODemo.Properties;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;


//读写配置文件
public class PropertiesDemo {
    public static void main(String[] args) {   }

    @Test
    public void Method01() throws IOException {
        //普通方法：读取配置文件，并获取相应的value
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Properties\\mysql.properties";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        //底层还是FileInputStream
        String readLine;
        String ip = null;
        String user = null;
        String pwd = null;
        while ((readLine = bufferedReader.readLine()) != null){
            if (readLine.contains("ip")){
                ip = readLine.split("=")[1];
            }
            if (readLine.contains("user")){
                user = readLine.split("=")[1];
            }
            if (readLine.contains("pwd")){
                pwd = readLine.split("=")[1];
            }
        }
        System.out.println("ip=" + ip + "user=" + user + "pwd=" + pwd);
        bufferedReader.close();
    }


    @Test
    public void useProperties() throws IOException {
        //Properties类方式实现
        String filePath = "D:\\Project\\Java\\JavaProject\\src\\IODemo\\Properties\\mysql.properties";
        //创建对象
        Properties properties = new Properties();
        //加载指定配置文件
        properties.load(new FileReader(filePath));
        properties.list(System.out);

        //根据k获取v
        String user = properties.getProperty("user");
        System.out.println(user);

        //创建键值对
        properties.setProperty("database", "test");
        properties.list(System.out);//打印显示创建成功了，但是看文件还没有写进去
        properties.store(new FileWriter(filePath), null);//到这里才是写进文件里去

        //修改键值对
        properties.setProperty("user", "肖锴"); // 中文保存的是unicode编码
        properties.list(System.out);//打印显示创建成功了，但是看文件还没有写进去
        properties.store(new FileWriter(filePath), null);//到这里才是写进文件里去

        //底层调用HashTable的put方法
        /*
        public synchronized V put(K key, V value) {
            // Make sure the value is not null
            if (value == null) {
                throw new NullPointerException();
            }

            // Makes sure the key is not already in the hashtable.
            Entry<?,?> tab[] = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;
            @SuppressWarnings("unchecked")
            Entry<K,V> entry = (Entry<K,V>)tab[index];
            for(; entry != null ; entry = entry.next) {
                if ((entry.hash == hash) && entry.key.equals(key)) {
                    V old = entry.value;
                    entry.value = value;
                    return old;
                }
            }

            addEntry(hash, key, value, index);
            return null;
        }
         */

        properties.clear();
    }
}
