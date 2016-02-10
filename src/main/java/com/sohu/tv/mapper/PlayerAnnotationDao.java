package com.sohu.tv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sohu.tv.bean.Player;

/**
 * 
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午11:01:00
 */
public interface PlayerAnnotationDao {
    
    @Select("select id,name,age from players where id=#{id}")
    Player get(int id);

    @Insert("insert into players(name,age) values(#{name},#{age})")
    int save(Player player);

    @Update("update players set name=#{name},age=#{age} where id=#{id}")
    int update(Player player);

    @Delete("delete from players where id=#{id}")
    int delete(int id);

    @Select("select id,name,age from players")
    List<Player> getAll();
}
