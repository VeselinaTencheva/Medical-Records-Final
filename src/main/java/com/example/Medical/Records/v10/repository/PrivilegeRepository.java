package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);

    Optional<Privilege> findById(Long id);
}
