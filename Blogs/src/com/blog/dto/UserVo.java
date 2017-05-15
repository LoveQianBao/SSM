package com.blog.dto;

import java.util.List;

public class UserVo
{
    private List<Integer> list;
    private User user;

    public List<Integer> getList()
    {
        return list;
    }

    public void setList(List<Integer> list)
    {
        this.list = list;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
