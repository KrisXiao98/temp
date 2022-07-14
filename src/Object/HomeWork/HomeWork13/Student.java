package Object.HomeWork.HomeWork13;

public class Student extends Person{
    public String name;
    public char gender;
    private int age;
    private int stu_id;

    public Student(String name, char gender, int age, int stu_id) {
        super(name, gender, age);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.stu_id = stu_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    public void study(){
        System.out.println("我承诺，我会好好学习");
    }

    public void play(){
        System.out.println(name + "爱踢足球。");
    }
}
