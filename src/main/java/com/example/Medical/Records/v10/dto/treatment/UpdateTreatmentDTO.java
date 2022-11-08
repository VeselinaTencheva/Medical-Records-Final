package com.example.Medical.Records.v10.dto.treatment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateTreatmentDTO {
    private String name;
    private String description;
}
