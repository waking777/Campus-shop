package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有的用户，同时获取他的所有账号信息
     * @return
     */
    List<User> findAll();

    /**
     * 查询所有用户2--注解开发
     */
    @Select("select * from user")
    List<User> findAll2();

    /**
     * 保存用户
     */
    void saveUser(User user);

    /**
     * 保存用户--注解开发
     */
    @Insert("insert into user(username,address,sex,birthday) values (#{username},#{address},#{sex},#{birthday})")
    void saveUser2(User user);
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
