package com.example.Medical.Records.v10.service.generalPractitioner;

import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import com.example.Medical.Records.v10.dto.physician.CreateGeneralPractitionerDTO;

import java.util.List;

public interface GeneralPractitionerService {
    List<GeneralPractitioner> findAll();

    GeneralPractitioner findById(Long id);

    GeneralPractitioner create(CreateGeneralPractitionerDTO generalPractitioner);

    GeneralPractitioner update(Long id, GeneralPractitioner generalPractitioner);

    void delete(Long id);
}
