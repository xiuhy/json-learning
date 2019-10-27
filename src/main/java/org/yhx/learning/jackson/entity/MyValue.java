package org.yhx.learning.jackson.entity;

public class MyValue {

    public String name;
    public int age;

    public MyValue(){}

    public MyValue(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyValue{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
