package GenericDemo.Exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

@SuppressWarnings({"all"})
public class Exercise01 {
    DAO<User> dao1 = new DAO<>();

    public static void main(String[] args) {
        System.out.println("main");
    }

    @Test
    public void testSave() {
        dao1.save("id01", new User("jack", 1, 18));
        System.out.println(dao1);
    }

    @Test
    public void testGet() {
        dao1.save("id01", new User("jack", 1, 18));
        System.out.println(dao1.get("id01"));
    }

    @Test
    public void testUpdate() {
        dao1.save("id01", new User("jack", 1, 18));
        dao1.update("id01", new User("tom", 2, 20));
        System.out.println(dao1);
    }

    @Test
    public void testList() {
        dao1.save("id01", new User("jack", 1, 18));
        dao1.save("id02", new User("jack1", 12, 18));
        for (User user : dao1.list()) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        dao1.save("id01", new User("jack", 1, 18));
        dao1.save("id02", new User("jack1", 12, 18));
        dao1.delete("id01");
        System.out.println(dao1);
    }

}

@SuppressWarnings({"all"})
class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        Set sets = map.keySet();
        ArrayList<T> arrayList = new ArrayList<>();
        for (Object set : sets) {
            arrayList.add(map.get(set));
        }
        return arrayList;
    }

    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

@SuppressWarnings({"all"})
class User {
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}