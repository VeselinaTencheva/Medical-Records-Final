package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    List<> findAllBy(Patient patient);
//        this one is the actual problem
        List<Patient> findDistinctByAppointmentsIn(List<Appointment> appointments);
}
