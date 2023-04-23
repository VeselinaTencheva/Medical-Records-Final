package com.example.Medical.Records.v10.dto.appointment;

import com.example.Medical.Records.v10.entity.Diagnosis;
import com.example.Medical.Records.v10.entity.Patient;
import com.example.Medical.Records.v10.entity.SickLeave;
import com.example.Medical.Records.v10.entity.Treatment;
import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAppointmentDTO {
//    private long id;
    private LocalDate date;

    private Patient patient;

    private Physician physician;

    private SickLeave sickLeave;

    private Diagnosis diagnosis;

    private Treatment treatment;
}
