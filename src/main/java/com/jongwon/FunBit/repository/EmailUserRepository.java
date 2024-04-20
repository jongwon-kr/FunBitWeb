package com.jongwon.FunBit.repository;

import com.jongwon.FunBit.Entity.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailUserRepository extends JpaRepository<EmailUser, Long> {

    EmailUser findByUsername(String username);

}
