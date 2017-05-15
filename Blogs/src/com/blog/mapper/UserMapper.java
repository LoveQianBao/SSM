package com.blog.mapper;

import java.util.List;

import com.blog.dto.User;
import com.blog.dto.UserVo;

public interface UserMapper
{
    public User findUserById(int id);

    public void insertUser(User user);

    public List<User> findUserByName(String name);

    public List<User> findUserList(UserVo user);

    public List<User> findUserList(User user);

}
