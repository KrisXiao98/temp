//package GenericDemo.Demo;
//
//import GenericDemo.Exercises.User;
//
//public class Demo02 {
//    public static void main(String[] args) {
//        System.out.println("hello");
//    }
//}
//
//
///*
//    1.Tiger后面泛型，所以我们把Tiger就成为自定义泛型类
//    2.T、R、M 泛型的标识符，一般是单个大写字母
//    3.泛型标识符可以有多个
//    4.普通成员可以使用泛型（属性、方法）
// */
//class Tiger<T, R ,M>{
//    String name;
//    R r;//属性使用到泛型
//    M m;
//    T t;
//
//    //public void hello(User s){}
//    //T[] ts = new T[8]; // 这里使用泛型的数组不能被初始化，因为new的时候不能T的类型，就无法在内存开空间。
//
//    //public static void function1(M m){} // 因为静态和类相关，在类加载时，对象还没创建。如果使用了泛型，JVM就无法完成初始化。
//}
