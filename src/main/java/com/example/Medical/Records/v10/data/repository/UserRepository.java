package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
//
//    User findByEmail (String email);
}
