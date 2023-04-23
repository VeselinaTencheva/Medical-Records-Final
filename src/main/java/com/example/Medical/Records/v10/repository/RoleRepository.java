package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {
    Role findByAuthority(String authority);

    Optional<Role> findById(Long id);
}
