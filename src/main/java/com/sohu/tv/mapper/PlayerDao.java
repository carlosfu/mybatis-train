package com.sohu.tv.mapper;

import com.sohu.tv.bean.Player;

/**
 * 球员信息接口
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午4:22:33
 */
public interface PlayerDao {

    Player getPlayerById(int id);
}
