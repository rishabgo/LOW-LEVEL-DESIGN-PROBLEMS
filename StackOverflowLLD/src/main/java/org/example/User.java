package org.example;

public class User {
    private final long id;
    private final String name;
    private final String userName;
    private final String password;
    private final String email;

    public User(long id, String name, String userName, String password, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
