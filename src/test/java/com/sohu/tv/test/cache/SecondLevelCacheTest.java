package com.sohu.tv.test.cache;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sohu.tv.bean.Player;
import com.sohu.tv.mapper.PlayerDao;
import com.sohu.tv.test.mapper.BaseTest;

/**
 * 二级缓存测试
 * 
 * @author leifu
 * @Date 2016-2-11
 * @Time 下午1:41:25
 */
public class SecondLevelCacheTest extends BaseTest {
    private SqlSession sqlSession1;
    private SqlSession sqlSession2;
    private SqlSession sqlSession3;

    private PlayerDao playerDao1;
    private PlayerDao playerDao2;
    private PlayerDao playerDao3;

    @Before
    public void before() {
        sqlSession1 = sessionFactory.openSession(false);
        sqlSession2 = sessionFactory.openSession(false);
        sqlSession3 = sessionFactory.openSession(false);

        playerDao1 = sqlSession1.getMapper(PlayerDao.class);
        playerDao2 = sqlSession2.getMapper(PlayerDao.class);
        playerDao3 = sqlSession3.getMapper(PlayerDao.class);

    }

    @After
    public void after() {
        sqlSession1.close();
        sqlSession2.close();
        sqlSession3.close();

    }

    @Test
    public void test1() {
        int id = 1;

        // sqlsession1查询，并提交到二级缓存
        Player player1 = playerDao1.get(id);
        logger.info("player1: {}", player1);

        // sqlsession2查询，修改并提交，清理二级缓存
        Player player2 = playerDao2.get(id);
        logger.info("player2: {}", player2);
    }

    @Test
    public void test2() {
        int one = 1;
        int two = 2;
        
        // sqlsession1查询，并提交到二级缓存
        Player player1 = playerDao1.get(one);
        logger.info("player1: {}", player1);
        logger.info("player2: {}", playerDao1.get(two));
        sqlSession1.commit();

        // sqlsession2查询，修改并提交，清理二级缓存
        Player player2 = playerDao2.get(two);
        logger.info("player2: {}", player2);
        player2.setAge(100);
        playerDao2.update(player2);
        sqlSession2.commit();

        // sqlsession3查询，不命中
        Player player3 = playerDao3.get(one);
        logger.info("player3: {}", player3);
    }

}
