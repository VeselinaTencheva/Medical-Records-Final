package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
