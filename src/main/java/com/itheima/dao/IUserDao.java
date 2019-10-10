package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有的操作
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     */
    void saveUser(User user);
}
