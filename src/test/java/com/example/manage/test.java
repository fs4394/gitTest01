package com.example.manage;

import com.example.manage.bean.User;
import com.example.manage.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * FileName:    test
 * Author:      Yuan-Programmer
 * Date:        2021/12/11 10:04
 * Description:
 */
@SpringBootTest
public class test {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test01(){
        User user = new User();
        user.setUsername("123");
        user.setPassword("456");
        user.setNickname("小明");
        userRepository.save(user);
    }

    @Test
    public void test02(){
        String find = "小";
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername(find);
        user.setNickname(find);
        try {
            Integer uid = Integer.parseInt(find);
            Optional<User> optional = userRepository.findById(uid);
            if (!optional.isPresent()) {
                list = selectVague(user);
            } else {
                list.add(optional.get());
            }
        }catch (NumberFormatException e) {
            list = selectVague(user);
        }
    }

    private List<User> selectVague(User user) {
        List<User> list = null;
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreCase("uid")
                .withIgnoreCase("password");
        Example<User> example = Example.of(user, matcher);
        list = userRepository.findAll(example);
        return list;
    }
}
