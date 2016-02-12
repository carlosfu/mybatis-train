package com.sohu.tv.bean;

import java.io.Serializable;

/**
 * 球员
 * 
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午4:20:49
 */
public class Player implements Serializable {

    private int id;

    private String name;

    private int age;
    
    private int clubId;
    
    private Club club;

    public Player() {
        super();
    }

    public Player(String name, int age, int clubId) {
        super();
        this.name = name;
        this.age = age;
        this.clubId = clubId;
    }

    public Player(int id, String name, int age, int clubId) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.clubId = clubId;
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

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + ", clubId=" + clubId + ", club=" + club + "]";
    }


}
