package Collection_Demo.ListModel;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Demo01 {
    public static void main(String[] args) {
        //创建一个空ArrayList,使用无参构造器
        //ArrayList arrayList = new ArrayList();
        ArrayList arrayList = new ArrayList(1);
        //添加10个数据进入arrayList
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        arrayList.add(11);
        System.out.println(arrayList);
    }
}
