package HashMapDemo.Exercises;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class Exercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("kris", 25, new MyDate(1998, 7, 21)));
        hashSet.add(new Employee("kris", 25, new MyDate(1998, 7, 21)));
        hashSet.add(new Employee("jack", 25, new MyDate(1998, 7, 21)));
        hashSet.add(new Employee("smith", 25, new MyDate(1998, 7, 21)));
        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int mouth;
    private int day;

    public MyDate(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && mouth == myDate.mouth && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, mouth, day);
    }
}

