package com.example.Medical.Records.v10.data.view.model.appointments;

import com.example.Medical.Records.v10.data.entity.Diagnosis;
import com.example.Medical.Records.v10.data.entity.Patient;
import com.example.Medical.Records.v10.data.entity.SickLeave;
import com.example.Medical.Records.v10.data.entity.Treatment;
import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import lombok.*;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAppointmentViewModel {
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate date;

    @NotBlank
    private Patient patient;
    @NotBlank
    private Physician physician;

    private SickLeave sickLeave;

    private Diagnosis diagnosis;

    private Treatment treatment;

    public CreateAppointmentViewModel(LocalDate date, Patient patient, Physician physician, SickLeave sickLeave, Diagnosis diagnosis) {
        this.date = date;
        this.patient = patient;
        this.physician = physician;
        this.sickLeave = sickLeave;
        this.diagnosis = diagnosis;
    }

    public CreateAppointmentViewModel(LocalDate date, Patient patient, Physician physician,  Diagnosis diagnosis) {
        this.date = date;
        this.patient = patient;
        this.physician = physician;
        this.diagnosis = diagnosis;
    }
}
