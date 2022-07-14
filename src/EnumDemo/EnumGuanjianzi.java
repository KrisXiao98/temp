package EnumDemo;

public class EnumGuanjianzi {
    public static void main(String[] args) {

    }

}

//使用enum关键字
enum Season2{
    SPRING("Spring", "温暖"),SUMMER("Summer", "炎热");
    private String name;
    private String description;

    Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
