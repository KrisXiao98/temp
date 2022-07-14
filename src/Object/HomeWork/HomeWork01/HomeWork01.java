package Object.HomeWork.HomeWork01;

public class HomeWork01 {
    // 定义Person类，初始化person对象，age从大到小排序.
    public static void main(String[] args) {
        Person[] personArray = new Person[3];
        personArray[0] = new Person("Kris", 18, "Boss");
        personArray[1] = new Person("jack", 20, "Manager");
        personArray[2] = new Person("smith", 19, "Worker");
        for (int i = 0; i < personArray.length - 1 ; i++) {
            for (int j = 0; j < personArray.length - i - 1; j++) {
                Person temp = personArray[j];
                if(personArray[j].getAge() < personArray[j+1].getAge()){
                    personArray[j] = personArray[j+1];
                    personArray[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < personArray.length; i++) {
            System.out.println(personArray[i].getAge());
        }
    }
}

class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public int getAge() {
        return age;
    }
}