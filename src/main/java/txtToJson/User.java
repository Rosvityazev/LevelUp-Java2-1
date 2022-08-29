package txtToJson;

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


}

