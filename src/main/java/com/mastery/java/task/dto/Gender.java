package com.mastery.java.task.dto;

public enum Gender {
    mode1 ("MALE"),
    mode2 ("FEMALE"),
    mode3 ("NONBINARY");

    private final String name;

    Gender(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
