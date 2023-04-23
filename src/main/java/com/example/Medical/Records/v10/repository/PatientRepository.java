package com.example.Medical.Records.v10.repository;

import com.example.Medical.Records.v10.entity.Appointment;
import com.example.Medical.Records.v10.entity.Patient;
//import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    List<> findAllBy(Patient patient);
//        this one is the actual problem
        List<Patient> findDistinctByAppointmentsIn(List<Appointment> appointments);
//        List<Patient> findDistinctByGeneralPractitioner(GeneralPractitioner generalPractitioner);

}
