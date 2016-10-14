package com.example.SpringDataTest;

import com.example.DemoApplication;
import com.example.SpringData.dao.CareRepository;
import com.example.SpringData.dao.UserRepository;
import com.example.SpringData.domain.Card;
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
public class oneToOneTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CareRepository careRepository;

    @Test
    public void test() throws Exception {

        // 创建测试数据
        careRepository.save(new Card(1, "aaabbbccc"));

        //正向保存
        Card care1 = new Card();
        care1.setCardId(1);
        userRepository.save(new User("Test1", 20, care1));

        //反向保存...

        //正向取数
        User user = userRepository.findByName("Test1");
        Card card = user.getCard();
        Assert.assertEquals("aaabbbccc", card.getCardNumber());

        //反向取数
        Card care = careRepository.findByCardNumber("aaabbbccc");
        User user_Temp = care.getUser();
        Assert.assertEquals("Test1", user_Temp.getName());

    }

}
