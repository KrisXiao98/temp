package Object;

public class EqualsExercises {
    public static void main(String[] args) {
        Person person = new Person("Kris", 18, '男');
        Person person2 = new Person("Kris", 18, '男');
        System.out.println(person.equals(person));
    }
}


class Person{
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public boolean equals(Object anObject){
        if(this == anObject){
            return true;
        }
        else if(anObject instanceof Person){
            if(name.equals(((Person) anObject).name) && age == ((Person) anObject).age && gender == ((Person) anObject).gender){
                return true;
            }
        }
        return false;
    }
}