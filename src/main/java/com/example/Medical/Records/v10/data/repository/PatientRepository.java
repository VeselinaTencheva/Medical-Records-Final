package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
