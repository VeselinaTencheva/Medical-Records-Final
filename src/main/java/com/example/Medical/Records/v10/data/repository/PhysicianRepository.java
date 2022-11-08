package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Long>  {
//    Set<Physician> findAllByFirstName(String name);
//    Set<Physician> findAllByDepartment(Department department);
}
