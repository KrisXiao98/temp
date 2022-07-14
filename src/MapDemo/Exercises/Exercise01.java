package MapDemo.Exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class Exercise01 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Worker kris = new Worker("Kris", 1, 25000);
        Worker jack = new Worker("Jack", 2, 10000);
        Worker mary = new Worker("Mary", 3, 8000);
        hashMap.put(kris.getId(), kris);
        hashMap.put(jack.getId(), jack);
        hashMap.put(mary.getId(), mary);

        //遍历工资,增强for
        System.out.println("====Way1====");
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            Object temp = hashMap.get(key);
            Worker worker = (Worker) temp;
            if (worker.getSalary() > 18000) {
                System.out.println(worker);
            }
        }

        //迭代器
        System.out.println("====Way2====");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            Worker temp = (Worker) hashMap.get(iterator.next());
            if (temp.getSalary() > 18000) {
                System.out.println(temp);
            }
        }
    }
}

class Worker{
    private String name;
    private int id;

    private double salary;

    public Worker(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + id +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}