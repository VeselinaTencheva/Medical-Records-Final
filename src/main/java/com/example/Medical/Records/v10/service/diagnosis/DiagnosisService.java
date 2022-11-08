package com.example.Medical.Records.v10.service.diagnosis;

import com.example.Medical.Records.v10.data.entity.Diagnosis;
import com.example.Medical.Records.v10.dto.diagnoses.CreateDiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.DiagnoseDTO;
import com.example.Medical.Records.v10.dto.diagnoses.UpdateDiagnoseDTO;

import java.util.List;

public interface DiagnosisService {
    List<DiagnoseDTO> findAll();

    DiagnoseDTO findById(Long id);

    DiagnoseDTO create(CreateDiagnoseDTO diagnosis);

    DiagnoseDTO update(Long id, UpdateDiagnoseDTO diagnosis);

    void delete(Long id);
}
