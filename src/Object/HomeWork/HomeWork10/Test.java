package Object.HomeWork.HomeWork10;

public class Test {
    public static void main(String[] args) {

    }
}

class Doctor{
    public String name;
    private int age;
    private String job;
    public char gender;
    private double salary;

    public Doctor(String name, int age, String job, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }else if (obj instanceof Doctor){
            return ((Doctor) obj).name.equals(this.name) && ((Doctor) obj).age == this.age && ((Doctor) obj).job.equals(this.job)
            && ((Doctor) obj).gender == this.gender && ((Doctor) obj).salary == this.salary;
        }else {
            System.out.println("你输入的对象有误");
            return false;
        }
    }
}