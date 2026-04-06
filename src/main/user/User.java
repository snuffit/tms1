package main.user;

import java.util.Objects;

/**
 * @author Pstyga Stas
 * @created 06.04.2026
 */
public class User implements Cloneable{

    private String username;
    private int age;
    private long id;

    public User(String username, int age, long id) {
        this.username = username;
        this.age = age;
        this.id = id;

    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return age == user.age && id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, id);
    }

    @Override
    public String toString() {
        return "User: username = '" + username + "', age = " + age + ", id = " + id;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        System.out.println("Поверхностное клонирование");
        return (User) super.clone();
    }
}
