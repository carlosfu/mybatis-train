package com.sohu.tv.bean;

import java.util.Date;

/**
 * 俱乐部
 * @author leifu
 * @Date 2016-2-10
 * @Time 上午10:19:42
 */
public class Club {

    private int id;
    
    private String name;
    
    private String info;
    
    private Date createDate;
    
    private int rank;
    
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Club [id=" + id + ", name=" + name + ", info=" + info + ", createDate=" + createDate + ", rank=" + rank
                + "]";
    }
    
    
}
