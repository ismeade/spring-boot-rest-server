package com.ade.demo.server.repository;

import com.ade.demo.server.repository.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TUser, Long> {
}
