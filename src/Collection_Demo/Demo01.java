package Collection_Demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Demo01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.创建一个Collection集合，多态的概念。编译类型是col，运行类型是ArrayList
        Collection col = new ArrayList();
        //2.增加几个对象，调用ArrayList的add方法
        col.add("String jack");
        col.add(10);
        col.add('A');
        col.add(123.456);
        //3.所有实现了Collection接口的集合类都有一个iterator方法，用来返回一个实现了Iterator接口的的对象，即迭代器
        Iterator iterator = col.iterator();
        //4.使用Iterator的hasNext方法用来判断迭代器是否还含有下一个元素，必须要使用，否则报错
        while (iterator.hasNext()) {
            //为什么是object类的，因为集合里面的数据类型不是固定的。运行类型还是对应元素的方法
            Object next =  iterator.next();
            System.out.println(next.toString());
        }
        //5.怎么再次从头开始遍历？重置迭代器即可
        iterator = col.iterator();
    }
}
