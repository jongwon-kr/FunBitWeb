package com.jongwon.FunBit.repository;

import com.jongwon.FunBit.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    boolean existsByUsername(String username);

    // user 조회
    User findByUsername(String username);
}
