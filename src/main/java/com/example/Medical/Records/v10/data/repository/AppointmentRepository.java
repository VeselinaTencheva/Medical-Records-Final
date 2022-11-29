package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Diagnosis;
import com.example.Medical.Records.v10.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByPatient(Patient patient);

    List<Appointment> findAllByDiagnosis(Diagnosis diagnosis);
}
