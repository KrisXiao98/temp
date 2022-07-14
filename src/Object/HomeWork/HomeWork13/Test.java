package Object.HomeWork.HomeWork13;

import org.omg.CORBA.PERSIST_STORE;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    //    多态数组，保存2个学生和2个教师，按照年龄要求从高到低排序
        Person[] people = new Person[4];
        people[0] = new Student("jack", '男', 16, 240802001);
        people[1] = new Student("rose", '女', 15, 240802002);
        people[2] = new Teacher("smith", '男', 42, 5);
        people[3] = new Teacher("justin", '女', 36, 10);
    //    排序
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length - i - 1; j++) {
                Person temp = people[j];
                if(people[j].getAge() < people[j+1].getAge()){
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }
    //    打印排序后的people的所有信息
        for (int i = 0; i < people.length; i++) {
            if(people[i] instanceof Student){
                System.out.println("学生的信息：");
                System.out.println("姓名：" + people[i].name);
                System.out.println("年龄：" + people[i].getAge());
                System.out.println("性别："+ people[i].gender);
                System.out.println("学号：" + ((Student) people[i]).getStu_id());
                ((Student) people[i]).study();
                people[i].play();
                System.out.println("-------------------");
            } else if (people[i] instanceof Teacher) {
                System.out.println("老师的信息：");
                System.out.println("姓名：" + people[i].name);
                System.out.println("年龄：" + people[i].getAge());
                System.out.println("性别："+ people[i].gender);
                System.out.println("工龄：" + ((Teacher) people[i]).getWork_age());
                ((Teacher) people[i]).teach();
                people[i].play();
                System.out.println("-------------------");
            }else {
                System.out.println("列表参数有误");
                System.out.println("-------------------");
            }
        }

    }

}


