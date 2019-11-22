package com.itheima.dao;

import com.itheima.domain.QueryVo;
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

    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(Integer userId);

    /**
     * 根据ID查询用户信息
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询
     */
    List<User> findByName(String username);

    /**
     * 查询总的用户数
     */
    int findTotal();

    /**
     * 根据vo来模糊查询
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 根据条件来查询，
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据ids来查询数据
     */
    List<User> findUserInIds(QueryVo vo);
}
