package com.blog.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.blog.dto.User;
import com.blog.dto.UserVo;

public class UserMapperTest
{

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void set() throws IOException
    {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    // @Test
    public void testFindUserById() throws IOException
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(16);
        System.out.println(user.toString());
    }

    @Test
    public void testFindUserList() throws IOException
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        UserVo userVo = new UserVo();

        List idList = new ArrayList<>();
        idList.add(16);
        idList.add(24);
        // user.setId(10);
        user.setUsername("张");
        userVo.setUser(user);
        userVo.setList(idList);
        List<User> list = userMapper.findUserList(userVo);

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).toString());

        }
    }

    // @Test
    public void testFindUserByName() throws IOException
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByName("张");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).toString());

        }
    }

    // @Test
    public void testInsertUser() throws IOException
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAddress("aa");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setUsername("wxf");
        userMapper.insertUser(user);
        sqlSession.commit();
    }

}
