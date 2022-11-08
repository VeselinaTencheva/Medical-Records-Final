package com.example.Medical.Records.v10.service.physician;

import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import com.example.Medical.Records.v10.dto.physician.CreatePhysicianDTO;
import com.example.Medical.Records.v10.dto.physician.PhysicianDTO;
import com.example.Medical.Records.v10.dto.physician.UpdatePhysicianDTO;

import java.util.List;

public interface PhysicianService {
    List<PhysicianDTO> findAll();

    Physician findById(Long id);

    Physician create(CreatePhysicianDTO physician);

    Physician update(Long id, UpdatePhysicianDTO physician);

    void delete(Long id);
}
