package com.tooonly.bean;

public class Person {

    private String id;
    private String name;
    private String password;
    private String age;


    public Person(String id, String name, String password, String age) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
//提供set和get方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}