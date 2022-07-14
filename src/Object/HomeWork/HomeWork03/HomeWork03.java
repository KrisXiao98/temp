package Object.HomeWork.HomeWork03;

public class HomeWork03 {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Teacher Ma", 20, "老师", 5000);
        teacher1.introduce();
        Professor professor = new Professor("professor Xiao", 25, "教授", 50000);
        professor.introduce();
    }
}

class Teacher {
    public String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getPost() {
        return post;
    }

    public double getSalary() {
        return salary;
    }

    public void introduce() {
        System.out.println("Teacher name is " + name + " age is " + age + " post is " + post + " salary is " + salary);
    }

}

class Professor extends Teacher {

    private double salaryLevel = 1.3;

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.println("Teacher name is " + name + " age is " + this.getAge() + " post is " + this.getPost() + " salary is " + this.getSalary()
        + " salaryLevel is " + salaryLevel);
    }


}

class AssociateProfessor extends Teacher {
    private double salaryLevel = 1.2;

    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.println("Teacher name is " + name + " age is " + this.getAge() + " post is " + this.getPost() + " salary is " + this.getSalary()
                + " salaryLevel is " + salaryLevel);
    }
}

class Lecturer extends Teacher {
    private double salaryLevel = 1.1;

    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.println("Teacher name is " + name + " age is " + this.getAge() + " post is " + this.getPost() + " salary is " + this.getSalary()
                + " salaryLevel is " + salaryLevel);
    }
}

