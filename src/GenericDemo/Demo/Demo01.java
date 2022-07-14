package GenericDemo.Demo;

import InnerClass.LocalInnerClass.Demo;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 5200, new MyDate(1997, 5, 20)));
        employees.add(new Employee("tom", 20000, new MyDate(2000, 6, 11)));
        employees.add(new Employee("jack", 22000, new MyDate(1998, 8, 10)));
        //排序，先按照name排序，如果name相同按照生日大小排序
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int temp = o1.getName().compareTo(o2.getName());
                if (temp != 0) {
                    return temp;
                }
                return o1.getBirthday().compareTo(o2.getBirthday());

            }
        });
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double salary;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name=" + name + " salary=" + salary + " birthday=" + birthday;
    }

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    //public int judgeBirthday(MyDate otherBirthday) {
    //    if (otherBirthday == this) {
    //        return 0;
    //    }
    //    String birthdayData = "" + this.year + this.month + this.day;
    //    String birthdayData1 = "" + otherBirthday.year + otherBirthday.month + otherBirthday.day;
    //    int intBirthday = new Integer(birthdayData);
    //    int intBirthday1 = new Integer(birthdayData1);
    //    //System.out.println(intBirthday + " " + intBirthday1);
    //    return intBirthday - intBirthday1;
    //}

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public int compareTo(MyDate otherBirthday) {
        String birthdayData = "" + this.year + this.month + this.day;
        String birthdayData1 = "" + otherBirthday.year + otherBirthday.month + otherBirthday.day;
        int intBirthday = new Integer(birthdayData);
        int intBirthday1 = new Integer(birthdayData1);
        //System.out.println(intBirthday + " " + intBirthday1);
        return intBirthday - intBirthday1;
    }
}
