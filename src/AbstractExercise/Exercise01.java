package AbstractExercise;

public class Exercise01 {
    public static void main(String[] args) {
        CommonEmployee person1 = new CommonEmployee("员工1", 223, 3000);
        Manager person2 = new Manager("经理1", 10, 8000, 2000);
        person1.work();
        person1.printInfo();
        person2.work();
        person2.printInfo();
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    protected abstract void work();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    void printInfo(){
        System.out.println("name:" + getName() + "id:" + getId() + "salary:" + getSalary());
    }

    @Override
    protected void work() {
        System.out.println("普通员工" + getName() + "正在工作中。。。。");
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    void printInfo(){
        System.out.println("name:" + getName() + "id:" + getId() + "salary:" + getSalary() + "bonus:" + getBonus());
    }

    @Override
    protected void work() {
        System.out.println("经理" + getName() + "正在工作中。。。。");

    }
}