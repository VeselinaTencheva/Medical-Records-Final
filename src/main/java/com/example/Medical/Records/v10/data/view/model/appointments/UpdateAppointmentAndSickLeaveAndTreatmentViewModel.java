package com.example.Medical.Records.v10.data.view.model.appointments;

import com.example.Medical.Records.v10.entity.Diagnosis;
import com.example.Medical.Records.v10.entity.Patient;
import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAppointmentAndSickLeaveAndTreatmentViewModel {
    private long id;

    @NotNull(message = "Date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be in the future or present")
    private LocalDate date;

    @NotNull(message = "Patient is mandatory")
    private Patient patient;

    @NotNull(message = "Physician is mandatory")
    private Physician physician;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be in the future or present")
    private LocalDate sickLeaveStartDate;

//    @Min(0)
//    @Max(180)
    private int sickLeaveDuration;

    private Diagnosis diagnosis;

//    @NotBlank
//    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String treatmentName;

//    @NotBlank
//    @Size(min = 5, max = 50, message="Min 5, Max 50")
    private String treatmentDescription;

}
