package Object.HomeWork.HomeWork04;

public class Test {
    public static void main(String[] args) {
        Worker jack = new Worker("jack", 250, 24);
        Manager smith = new Manager("smith", 500, 26);
        jack.showSalary();
        smith.showSalary();
    }
}

class Employees {
    public String name;
    private double salaryDaily;
    private int days;

    public Employees(String name, double salaryDaily, int days) {
        this.name = name;
        this.salaryDaily = salaryDaily;
        this.days = days;
    }

    public void showSalary() {
        System.out.println("员工名字" + name + "的工资为" + salaryDaily * days);
    }

    public double getSalaryDaily() {
        return salaryDaily;
    }

    public int getDays() {
        return days;
    }

}

class Manager extends Employees {
    private double baseSalary = 1000;
    private double salaryLevel = 1.2;

    public Manager(String name, double salaryDaily, int days) {
        super(name, salaryDaily, days);
    }

    public void showSalary() {
        System.out.println("员工名字" + name + "的工资为" + getSalaryDaily() * getDays() * salaryLevel + 1000);
    }

}

class Worker extends Employees {
    private double salaryLevel = 1.0;

    public Worker(String name, double salaryDaily, int days) {
        super(name, salaryDaily, days);
    }

    public void showSalary() {
        System.out.println("员工名字" + name + "的工资为" + getSalaryDaily() * getDays() * salaryLevel);
    }
}