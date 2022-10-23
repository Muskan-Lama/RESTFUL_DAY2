package com.TTN.restfulday2.versioning;

public class UserV1 {
    private String name;

    @Override
    public String toString() {
        return "UserV1{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public UserV1(String name) {
        this.name = name;
    }
}
