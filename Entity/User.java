package com.ly.SpringBoot.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class User {
    @Value("${ly.name}")
    private String name;
    @Value("${ly.age}")
    private int age;

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
}
