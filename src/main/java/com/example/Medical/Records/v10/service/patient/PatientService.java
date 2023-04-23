package com.example.Medical.Records.v10.service.patient;

import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.patient.CreatePatientDTO;
import com.example.Medical.Records.v10.dto.patient.PatientDTO;
import com.example.Medical.Records.v10.dto.patient.UpdatePatientDTO;

import java.util.List;
public interface PatientService {
    List<PatientDTO> findAll();

    List<DiagnoseDTO> findAllDiagnosesPerPatient(long id);

    PatientDTO findById(Long id);

    PatientDTO create(CreatePatientDTO createPatientDTO);

    PatientDTO update(Long id, UpdatePatientDTO updatePatientDTO);

    void delete(Long id);
}
