package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * mybatis的入门案例
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlsession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlsession = factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlsession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        //提交事务
        //sqlsession.commit();
        //6.释放资源
        sqlsession.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("auto-otto");
        user.setAddress("上海市闵行区");
        user.setSex("男");
        user.setBirthday(new Date());
        //5.执行保存方法
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(51);
        user.setUsername("mybatis updateusername");
        user.setAddress("上海市闵行区");
        user.setSex("男");
        user.setBirthday(new Date());
        //5.执行保存方法
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(51);
    }

    @Test
    public void testSelectById() {
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void testSelectByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testSelectByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for (User u : users) {
            System.out.println(u);
            System.out.println("1");
        }
    }

    @Test
    public void testFindUserByCondition() {
        User u = new User();
        u.setUsername("周冬雨");
        u.setSex("男");
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     *
     */
    @Test
    public void testFindInIds() {
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        queryVo.setIds(list);

        List<User> users = userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
