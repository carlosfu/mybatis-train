package com.sohu.tv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sohu.tv.bean.Club;

/**
 * 俱乐部dao
 * @author leifu
 * @Date 2016-2-10
 * @Time 上午10:21:01
 */
public interface ClubDao {
    
    List<Club> getAll();
    
    List<Club> getByName(String name);
    
    void updateRank(@Param("id") int id, @Param("rank") int rank);
    
    List<Club> getByIds(@Param("ids") List<Integer> ids);
    
    
}
