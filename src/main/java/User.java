import java.util.Objects;

public class User {
    private String login;
    private String name;
    private int age;
    private int bonuses;

    public User(String login, String name, int age, int bonuses) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.bonuses = bonuses;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && bonuses == user.bonuses && Objects.equals(login, user.login) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, bonuses);
    }
}

