package com.example.Medical.Records.v10.data.view.model.treatments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentViewModel {
    private long id;
    private String name;
    private String description;
}
