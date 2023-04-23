package com.example.Medical.Records.v10.data.view.model.patients;

import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientViewModel {
    private Long id;
    private String name;
    private String ssn;
    private boolean hasInsurance;
    private Physician physician;
}
