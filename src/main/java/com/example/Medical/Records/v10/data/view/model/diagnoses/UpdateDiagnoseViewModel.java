package com.example.Medical.Records.v10.data.view.model.diagnoses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDiagnoseViewModel {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max=30, message = "Name must be between 5 and 30 characters")
    private String name;

    @Size(min = 5, max=50, message = "Description must be between 5 and 50 characters")
    private String description;
}
