package com.gqq.client;

public class User {
    public int id;
    public String name;
    public int sex;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
