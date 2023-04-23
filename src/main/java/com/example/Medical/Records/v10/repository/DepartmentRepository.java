package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}