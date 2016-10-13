package com.example.SpringDataTest;

import com.example.DemoApplication;
import com.example.SpringData.dao.UserRepository;
import com.example.SpringData.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Brave on 16/10/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class exampleTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        // 创建测试数据
        userRepository.save(new User("Test1", 10));
        userRepository.save(new User("Test2", 20));
        userRepository.save(new User("Test3", 30));
        userRepository.save(new User("Test4", 40));
        userRepository.save(new User("Test5", 50));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(5, userRepository.findAll().size());

        // 测试findByName, 查询姓名为Test2的User.Age=20
        Assert.assertEquals(20, userRepository.findByName("Test2").getAge().longValue());

        // 测试findUser, 查询姓名为Test3的User.Age=30
        Assert.assertEquals(30, userRepository.findUser("Test3").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为Test4并且年龄为40的User
        Assert.assertEquals("Test4", userRepository.findByNameAndAge("Test4", 40).getName());

        // 测试删除姓名为Test5的User
        userRepository.delete(userRepository.findByName("Test5"));

        // 测试findAll, 删除后为4条记录
        Assert.assertEquals(4, userRepository.findAll().size());

    }

}
