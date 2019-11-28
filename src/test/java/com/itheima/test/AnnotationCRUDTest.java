package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("Annotation-mybatis");
        user.setAddress("上海市闵行区");

        userDao.saveUser2(user);
    }

    @Test
    public void testUpate() {
        User user = new User();
        user.setId(54);
        user.setAddress("长沙");
        user.setUsername("周冬雨");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser2(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser2(55);
    }


    @Test
    public void testFindById() {
        User user = userDao.findById2(54);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName2("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        System.out.println(userDao.findTotal2());
    }

}
