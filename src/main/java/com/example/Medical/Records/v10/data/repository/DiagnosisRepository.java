package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
