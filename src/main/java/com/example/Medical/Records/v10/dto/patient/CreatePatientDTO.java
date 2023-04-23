package com.example.Medical.Records.v10.dto.patient;

import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePatientDTO {
    private String name;

    private String ssn;

    private boolean hasInsurance;

    private Physician physician;
}