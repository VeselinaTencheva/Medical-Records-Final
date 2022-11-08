package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
