package com.example.Medical.Records.v10.dto.patient;

import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String ssn;
    private boolean hasInsurance;
    private Physician physician;
}