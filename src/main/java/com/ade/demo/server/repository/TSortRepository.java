package com.ade.demo.server.repository;

import com.ade.demo.server.repository.entity.TSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSortRepository extends JpaRepository<TSort, Long> {
}
