package com.example.Medical.Records.v10.service.treatment;

import com.example.Medical.Records.v10.data.entity.Treatment;
import com.example.Medical.Records.v10.dto.treatment.CreateTreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.TreatmentDTO;
import com.example.Medical.Records.v10.dto.treatment.UpdateTreatmentDTO;

import java.util.List;

public interface TreatmentService {
    List<TreatmentDTO> findAll();

    TreatmentDTO findById(Long id);

    TreatmentDTO create(CreateTreatmentDTO treatment);

    TreatmentDTO update(Long id, UpdateTreatmentDTO treatment);

    void delete(Long id);
}
