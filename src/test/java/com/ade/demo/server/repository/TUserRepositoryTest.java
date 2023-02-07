package com.ade.demo.server.repository;

import com.ade.demo.server.repository.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TUserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void create() {
        TUser TUser = new TUser();
        TUser.setName("tom2");
        TUser.setAge(11);
        userRepository.save(TUser);

        System.out.println(TUser);

        System.out.println(userRepository.findAll());
    }

    @Test
    void list() {
        System.out.println(userRepository.findAll());
    }

}