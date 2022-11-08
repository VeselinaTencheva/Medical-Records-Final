package com.example.Medical.Records.v10.dto.diagnoses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnoseDTO {
    private long id;
    private String name;
    private String description;
}
