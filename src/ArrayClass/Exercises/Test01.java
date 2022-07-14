package ArrayClass.Exercises;

import CodeBlock.B;

import java.util.Arrays;
import java.util.Comparator;


public class Test01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 20.5);
        books[1] = new Book("红楼梦1", 20.9);
        books[2] = new Book("红楼梦22", 40);
        books[3] = new Book("红楼梦333", 25);

        //第1种，按照价格从小到大
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                if (book1.getPrice() - book2.getPrice() > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        //第2中，从大到小的price
        Book[] books2 = Arrays.copyOf(books, books.length);
        Arrays.sort(books2, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() - o2.getPrice() < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(books2));

        //第三种根据name长度排序
        Book[] books3 = Arrays.copyOf(books, books.length);
        Arrays.sort(books3, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getNameLength() - o2.getNameLength() < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(books3));
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getNameLength() {
        return name.length();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}