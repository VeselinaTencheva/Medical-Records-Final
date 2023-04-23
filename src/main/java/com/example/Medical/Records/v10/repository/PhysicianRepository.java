package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.physicians.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Long>  {
//    Set<Physician> findAllByFirstName(String name);
//    Set<Physician> findAllByDepartment(Department department);
}
