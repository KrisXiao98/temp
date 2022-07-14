package ArrayClass.Demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Array01 {
    public static void main(String[] args) {
        Integer[] num1 = {1, 2, 333, 2, 111, 22, 3, 0};
        Arrays.sort(num1);
        System.out.println(Arrays.toString(num1));//[0, 1, 2, 2, 3, 22, 111, 333]
        int index = Arrays.binarySearch(num1, 333);
        int index2 = Arrays.binarySearch(num1, 4);
        System.out.println(index);//7
        System.out.println(index2);//-6  本该在索引5处，然后-（5+1）

        Integer[] num2 = Arrays.copyOf(num1, num1.length);
        System.out.println(Arrays.toString(num2));

        //fill数组填充
        //Arrays.fill(num1, 99);
        //System.out.println(Arrays.toString(num1));//[99, 99, 99, 99, 99, 99, 99, 99]

        //equals方法
        System.out.println(Arrays.equals(num1, num2));

        //aList方法
        List asList = Arrays.asList(2,3,4,5,6,1,2);
        System.out.println(asList);//[2, 3, 4, 5, 6, 1, 2]
    }

}
