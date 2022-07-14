package Object.HomeWork.HomeWork13;

public class Teacher extends Person{
    public String name;
    public char gender;
    private int age;
    private int work_age;

    public Teacher(String name, char gender, int age, int work_age) {
        super(name,gender,age);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.work_age = work_age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
    public void teach(){
        System.out.println("我承诺，我会认真教学");
    }

    public void play(){
        System.out.println(name + "爱玩象棋。");
    }
}
