package com.example.Medical.Records.v10.data.view.model.patients;

import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PatientViewModel {
    private Long id;
    private String name;
    private String ssn;
    private boolean hasInsurance;
    private Physician physician;
}
