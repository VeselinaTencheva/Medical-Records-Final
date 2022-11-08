package com.example.Medical.Records.v10.service.sickLeave;

import com.example.Medical.Records.v10.data.entity.SickLeave;
import com.example.Medical.Records.v10.dto.sickLeave.CreateSickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.SickLeaveDTO;
import com.example.Medical.Records.v10.dto.sickLeave.UpdateSickLeaveDTO;

import java.util.List;

public interface SickLeaveService {
    List<SickLeaveDTO> findAll();

    SickLeaveDTO findById(Long id);

    SickLeaveDTO create(CreateSickLeaveDTO sickLeave);

    SickLeaveDTO update(Long id, UpdateSickLeaveDTO sickLeave);

    void delete(Long id);
}
