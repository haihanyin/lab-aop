package com.github.hh.labaop.postcompile.demo_jacoco;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 100) {
            throw new IllegalArgumentException("Name is too long");
        }
        this.name = name;
    }
}
