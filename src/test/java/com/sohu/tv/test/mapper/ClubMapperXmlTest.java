package com.sohu.tv.test.mapper;

import java.util.ArrayList;
import java.util.Date;
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
    
    @Test
    public void testGetByName() {
        List<Club> list = clubDao.getByName("AC");
        for (Club club : list) {
            System.out.println(club);
        }
    }
    
    @Test
    public void testUpdateRank() {
        testGetAll();
        clubDao.updateRank(1, 3);
        System.out.println("after update rank...");
        testGetAll();
    }
    
    
    @Test
    public void testGetIds() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        
        List<Club> list = clubDao.getByIds(ids);
        for (Club club : list) {
            System.out.println(club);
        }
    }
    
    @Test  
    public void testBatchSave() {  
        ClubDao clubDao = sqlSession.getMapper(ClubDao.class);  
        
        Club club1 = new Club();  
        club1.setName("Arsenal");  
        club1.setInfo("阿森纳");  
        club1.setCreateDate(new Date());
        club1.setRank(15);  
        
        Club club2 = new Club();  
        club2.setName("ManUnited");  
        club2.setInfo("曼联");  
        club2.setCreateDate(new Date());  
        club2.setRank(18);  
           
        List<Club> clubList = new ArrayList<Club>();  
        clubList.add(club1);  
        clubList.add(club2);  
           
        int batchSaveResult = clubDao.batchSave(clubList);  
        System.out.println("batchSaveResult: " + batchSaveResult);
    }      
    

}
