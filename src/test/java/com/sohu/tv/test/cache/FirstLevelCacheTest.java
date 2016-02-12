package com.sohu.tv.test.cache;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sohu.tv.bean.Player;
import com.sohu.tv.mapper.PlayerDao;
import com.sohu.tv.test.mapper.BaseTest;

/**
 * 一级缓存测试
 * 
 * @author leifu
 * @Date 2016-2-11
 * @Time 下午1:41:25
 */
public class FirstLevelCacheTest extends BaseTest {
    private SqlSession sqlSession1;
    private SqlSession sqlSession2;

    @Before
    public void before() {
        sqlSession1 = sessionFactory.openSession(false);
        sqlSession2 = sessionFactory.openSession(false);

    }

    @After
    public void after() {
        sqlSession1.close();
        sqlSession2.close();
    }

    @Test
    public void test1() {
        int id = 1;
        
        //第一次查询，没有在sqlsession1中命中，即查询数据库
        PlayerDao playerDao = sqlSession1.getMapper(PlayerDao.class);
        Player player = playerDao.get(id);
        logger.info("player: {}", player);
        
        //命中
        playerDao = sqlSession1.getMapper(PlayerDao.class);
        player = playerDao.get(id);
        logger.info("player: {}", player);
        
        //sqlsession1和sqlsession2在一级缓存的层面上没有任何关系。
        playerDao = sqlSession2.getMapper(PlayerDao.class);
        player = playerDao.get(id);
        logger.info("player: {}", player);
        
    }
    
    @Test
    public void test2() {
        int id = 1;
        
        PlayerDao playerDao = sqlSession1.getMapper(PlayerDao.class);
        Player player = playerDao.get(id);
        logger.info("player: {}", player);
        
        //1. session提交
//        sqlSession1.commit();
//        sqlSession1.clearCache();
        
        playerDao.save(new Player("xxxxx", 20, 2));
        sqlSession1.commit();
        
        player = playerDao.get(id);
        logger.info("player: {}", player);
    }
    
    
    
    
    
    
    
    
    

}
