package com.sohu.tv.test.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sohu.tv.bean.Club;
import com.sohu.tv.mapper.ClubDao;

/**
 * 俱乐部测试
 * @author leifu
 * @Date 2016-2-10
 * @Time 上午10:23:36
 */
public class ClubMapperXmlTest extends BaseTest {

    private SqlSession sqlSession;

    private ClubDao clubDao;

    @Before
    public void before() {
        sqlSession = sessionFactory.openSession(true);
        clubDao = sqlSession.getMapper(ClubDao.class);
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }


    @Test
    public void testGetAll() {
        List<Club> list = clubDao.getAll();
        for (Club club : list) {
            System.out.println(club);
        }
    }

}
