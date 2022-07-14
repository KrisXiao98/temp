package EnumDemo.HomeWork;

public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println("===所有星期的信息如下===");
        Week[] weeks = Week.values();//获取所有的枚举对象值weeks数组中
        for (Week week : weeks) {// 相当于python的 for week in weeks
            System.out.println(week);
        }
    }
}

@SuppressWarnings({"all"})
enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THUSDAY("星期四"), FRIDAY("星期五"),
    SATURDAY("星期六"), SUNDAY("星期日");
    private String name;

    Week(String name) {
        this.name = name;
    }

    @Override
    //重写toString方法
    public String toString() {
        return name;
    }
}

interface IA{
    void hi();
}

interface IB{
    void say();
}
enum Test implements IA,IB{
    TEST;
    @Override
    public void hi() {
        System.out.println("hi");
    }

    @Override
    public void say() {
        System.out.println("say");
    }
}