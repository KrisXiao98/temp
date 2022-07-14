package CollectionHomeWork.HomeWork01;

import java.util.HashMap;
import java.util.Set;

@SuppressWarnings({"all"})
public class Work02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);

        //将jack的工资改为2600
        hashMap.put("jack", 2600);
        //所有员工工资增加100
        Set set = hashMap.keySet();
        for(Object key:set){
            hashMap.put(key, (Integer) hashMap.get(key) + 100);
        }
        //遍历集合所有的员工
        set = hashMap.keySet();
        for (Object key : set){
            System.out.println("员工=" + key);
            System.out.println("工资=" + hashMap.get(key));
        }

    }
}

