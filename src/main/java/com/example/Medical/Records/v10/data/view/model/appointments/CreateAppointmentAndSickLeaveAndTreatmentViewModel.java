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
public class CreateAppointmentAndSickLeaveAndTreatmentViewModel {

    @NotNull(message = "Date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be in the future or present")
    private LocalDate date = LocalDate.now();;;

    @NotNull(message = "Patient is mandatory")
    private Patient patient;

    @NotNull(message = "Physician is mandatory")
    private Physician physician;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be in the future or present")
    private LocalDate sickLeaveStartDate = LocalDate.now();;;

//    @Min(value = 1, message = "Sick Duration Days must be at least 1 day")
//    @Max(value = 180, message = "Sick Duration Days must be maximum 180 days")
    private int sickLeaveDuration;

    private Diagnosis diagnosis;

//    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String treatmentName;

//    @Size(min = 5, max = 50, message="Min 5, Max 50")
    private String treatmentDescription;

}
