package Java8NewFeatures.Lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

//lambda表达式举例
public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am Kris");
            }
        };

        runnable.run();
        System.out.println("=================使用lambda表达式:1-无参无返回值=================");
        Runnable runnable1 = () -> System.out.println("I am Kris");
        runnable1.run();
    }

    @Test
    public void Test01() {
        //需要参数，但是没有返回值
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("需要参数，但是没有返回值");
        System.out.println("=================使用lambda表达式:2-需要参数，但是没有返回值=================");
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("需要参数，但是没有返回值");

    }

    @Test
    public void Test02() {
        //数据类型可以是省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("需要参数，但是没有返回值");
        System.out.println("===使用lambda表达式:3-数据类型可以是省略，因为可由编译器推断得出，称为“类型推断”===");
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer2.accept("需要参数，但是没有返回值");

    }

    @Test
    public void Test03() {
        //lambda若只需要一个参数，参数的小括号可以省略
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer2.accept("需要参数，但是没有返回值");
        System.out.println("===使用lambda表达式:4-lambda若只需要一个参数，参数的小括号可以省略===");
        Consumer<String> consumer3 = s -> System.out.println(s);
        consumer3.accept("需要参数，但是没有返回值");
    }

    @Test
    public void Test04() {
        //lambda 需要2个或者以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(12, 23));
        System.out.println("===使用lambda表达式:5-lambda 需要2个或者以上的参数，多条执行语句，并且可以有返回值===");
        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(12, 23));
    }

    @Test
    public void Test05() {
        //lambda只有一条执行语句时，return 与大括号若有，都可以省略
        Comparator<Integer> comparator1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(12, 23));
        System.out.println("===使用lambda表达式:6-lambda只有一条执行语句时，return 与大括号若有，都可以省略===");
        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator2.compare(12, 23));
    }
}
