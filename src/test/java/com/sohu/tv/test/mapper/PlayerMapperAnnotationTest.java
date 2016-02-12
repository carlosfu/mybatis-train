package com.sohu.tv.test.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sohu.tv.bean.Player;
import com.sohu.tv.mapper.PlayerAnnotationDao;

/**
 * annotation mapper测试
 * @author leifu
 * @Date 2016-2-8
 * @Time 下午11:08:42
 */
public class PlayerMapperAnnotationTest extends BaseTest {

    private SqlSession sqlSession;

    private PlayerAnnotationDao playerAnnotationDao;

    @Before
    public void before() {
        sqlSession = sessionFactory.openSession(true);
        playerAnnotationDao = sqlSession.getMapper(PlayerAnnotationDao.class);
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void testGet() {
        Player player = playerAnnotationDao.get(2);
        System.out.println("player: " + player);
    }

    @Test
    public void testSave() {
        playerAnnotationDao.save(new Player("messi", 29, 2));
        testGetAll();
    }

    @Test
    public void testUpdate() {
        playerAnnotationDao.update(new Player(1, "c-r", 30, 3));
        testGetAll();
    }

    @Test
    public void testDelete() {
        playerAnnotationDao.delete(3);
        testGetAll();
    }

    @Test
    public void testGetAll() {
        List<Player> list = playerAnnotationDao.getAll();
        for (Player player : list) {
            System.out.println(player);
        }
    }

}
