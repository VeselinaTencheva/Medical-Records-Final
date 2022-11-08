package com.example.Medical.Records.v10.dto.physician;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGeneralPractitionerDTO {
    private String practiceCode;
    private String practiceAddress;
}
