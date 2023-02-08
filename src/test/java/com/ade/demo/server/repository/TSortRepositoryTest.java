package com.ade.demo.server.repository;

import com.ade.demo.server.repository.entity.TSort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TSortRepositoryTest {

    @Autowired
    TSortRepository TSortRepository;

    @Test
    void create() {
        TSort TSort = new TSort();
        TSort.setDateOrigin("123123");
        TSort.setDateSorted("125213");
        TSortRepository.save(TSort);

        System.out.println(TSort);

        System.out.println(TSortRepository.findAll());
    }

    @Test
    void list() {
        System.out.println(TSortRepository.findAll());
    }

}