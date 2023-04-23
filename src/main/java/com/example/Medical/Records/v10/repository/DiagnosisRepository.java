package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.Appointment;
import com.example.Medical.Records.v10.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Diagnosis findByAppointments(Appointment appointment);
}
