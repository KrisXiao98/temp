package EnumDemo;

public class EnumZidingyi {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        spring.f1(new Season.SeasonFunction() {
            @Override
            public void func() {
                System.out.println("春天万物复苏");
            }
        });
    }
}

//自定义枚举实现

class Season {
    private String season;
    private String description;

    //枚举实现：自己定义4个季节的对象，并设置为final static，外部类直接使用。个人感觉像单例设计模式里的饿汉式
    public static final Season SPRING = new Season("Spring", "温暖");
    public static final Season SUMMER = new Season("Summer", "炎热");
    public static final Season AUTUMN = new Season("Autumn", "凉爽");
    public static final Season WINNER = new Season("Winner", "寒冷");

    //构造器私有化，防止直接new,且不提供set方法，防止更改属性
    private Season(String season, String description) {
        this.season = season;
        this.description = description;
    }

    interface SeasonFunction {
        void func();
    }

    public void f1(SeasonFunction sf){
        sf.func();
    }

}
