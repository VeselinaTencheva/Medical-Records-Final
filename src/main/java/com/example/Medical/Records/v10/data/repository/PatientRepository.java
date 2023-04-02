package com.example.Medical.Records.v10.data.repository;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Patient;
//import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    List<> findAllBy(Patient patient);
//        this one is the actual problem
        List<Patient> findDistinctByAppointmentsIn(List<Appointment> appointments);
//        List<Patient> findDistinctByGeneralPractitioner(GeneralPractitioner generalPractitioner);

}
