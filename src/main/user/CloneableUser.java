package main.user;

/**
 * @author Pstyga Stas
 * @created 06.04.2026
 */
public class CloneableUser extends User{

    public CloneableUser(String username, int age, long id) {
        super(username, age, id);
    }

    @Override
    public CloneableUser clone() throws CloneNotSupportedException {
        System.out.println("Глубокое клонирование");
        return new CloneableUser(super.getUsername(), super.getAge(), super.getId());
    }
}
