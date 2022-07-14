package Collection_Demo.Exercises;


import java.util.ArrayList;
import java.util.List;

public class Exercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list01 = new ArrayList();
        Books book1 = new Books("Kris",  1563.45, "Kris Xiao");
        Books book2 = new Books("xixi",  123.456, "Kris Xiao1");
        Books book3 = new Books("haha",  1223.45, "Kris Xiao2");
        list01.add(book1);
        list01.add(book2);
        list01.add(book3);
        //冒泡排序list01，价格从低到高
        for (int i = 0; i < list01.size() - 1; i++) {
            for (int j = 0; j < list01.size() - i - 1; j++) {
                //重点：怎么取出book对象，用到向下转型，你想到了没有？？
                Books bookTemp1 = (Books) list01.get(j);
                Books bookTemp2 = (Books) list01.get(j+1);
                if (book1.getPrice() > book2.getPrice()){
                    list01.set(j, bookTemp2);
                    list01.set(j+1, bookTemp1);
                }
            }
        }
        for (Object o:
             list01) {
            System.out.println(o);
        }
    }
}

class Books {
    private String name;
    private Double price;
    private String author;

    public Books() {
    }

    public Books(String name, Double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t价格:" + price + "\t\t作者：" + author;
    }
}