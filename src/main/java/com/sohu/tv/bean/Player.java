package com.sohu.tv.bean;

/**
 * 球员
 * 
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午4:20:49
 */
public class Player {

    private int id;

    private String name;

    private int age;
    
    public Player() {
        super();
    }

    public Player(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}