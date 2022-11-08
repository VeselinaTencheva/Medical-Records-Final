package com.example.Medical.Records.v10.dto.patient;

import com.example.Medical.Records.v10.data.entity.physicians.GeneralPractitioner;
import com.sun.xml.bind.v2.TODO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdatePatientDTO {
    private String name;

    private String ssn;

    private boolean hasInsurance;

    private GeneralPractitioner generalPractitioner;
}
