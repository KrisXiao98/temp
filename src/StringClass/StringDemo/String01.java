package StringClass.StringDemo;

public class String01 {
    public static void main(String[] args) {
        int num1 = 1; //num1不能使用Integer的类的方法比如下面的toString()，所以这也是装箱的好处
        //num2采用自动装箱，实际就是等于Integer num2 = Integer.valueOf(2); valueOf根据-128~127直接返回，之外的值
        //会创建对象
        Integer num2 = 2;
        ///num3为使用构造器创建对象的方法，输入num3还是调用的num3的toString方法，请查看源码
        Integer num3 = new Integer(3);
        ///JDK5之前需要手动装箱的写法
        Integer num4 = Integer.valueOf(4);
        System.out.println(num1 + "\n" +  num2 + "\n" + num3 + "\n" + num4);
        System.out.println("==========");
        System.out.println(num2.toString());
        System.out.println("==========");
        System.out.println(num3.toString());
        System.out.println("==========");
        System.out.println(num4.toString());

        //解箱
        int num5 = num2;
        //实际是运用了intValue()方法
        System.out.println(num5);
    }
}
