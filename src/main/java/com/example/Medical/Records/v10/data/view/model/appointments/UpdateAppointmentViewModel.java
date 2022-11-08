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
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAppointmentViewModel {
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate date;

    private Patient patient;

    private Physician physician;

    private SickLeave sickLeave;

    private Diagnosis diagnosis;

    private Treatment treatment;
}
