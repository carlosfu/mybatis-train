package com.sohu.tv.test.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sohu.tv.bean.Player;
import com.sohu.tv.mapper.PlayerDao;

/**
 * xml mapper第二版
 * 
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午10:48:14
 */
public class PlayerMapperXmlTestV3 extends BaseTest {

    private SqlSession sqlSession;

    private PlayerDao playerDao;

    @Before
    public void before() {
        sqlSession = sessionFactory.openSession(true);
        playerDao = sqlSession.getMapper(PlayerDao.class);
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void testGet() {
        Player player = playerDao.get(2);
        System.out.println("player: " + player);
    }

    @Test
    public void testSave() {
        Player player = new Player("messi", 29);
        int saveResult = playerDao.save(player);
        System.out.println("saveResult: " + saveResult);
        System.out.println(player);
    }

    @Test
    public void testUpdate() {
        int updateResult = playerDao.update(new Player(19, "c-r", 30));
        System.out.println("updateResult: " + updateResult);
    }

    @Test
    public void testDelete() {
        int deleteResult = playerDao.delete(19);
        System.out.println("deleteResult: " + deleteResult);
    }

    @Test
    public void testGetAll() {
        List<Player> list = playerDao.getAll();
        for (Player player : list) {
            System.out.println(player);
        }
    }

}
