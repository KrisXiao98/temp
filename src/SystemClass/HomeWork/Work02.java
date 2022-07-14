package SystemClass.HomeWork;

import java.util.Arrays;

public class Work02 {
    public static void main(String[] args) {
        Person[] person = new Person[1];
        //如何扩容？新建一个数组，然后引用指向这个扩容的数组
        person[0] = new Person("Kris");
        //方式1
        Person[] person2 = Arrays.copyOf(person, person.length + 1);
        System.out.println(person2.length);
        System.out.println(person.length);
        //方式2,引用重新指向
        Person[] person3 = new Person[person.length + 1];
        person3[0] = person[0];
        person3[1] = new Person("xx");
        person = person3;
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
