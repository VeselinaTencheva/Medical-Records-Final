package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.physicians.GeneralPractitioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralPractitionerRepository extends JpaRepository<GeneralPractitioner, Long> {
}
