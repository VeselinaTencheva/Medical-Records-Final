package com.example.Medical.Records.v10.dto.sickLeave;

import com.example.Medical.Records.v10.entity.Appointment;
import com.example.Medical.Records.v10.entity.Patient;
import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SickLeaveDTO {
    private long id;
    private LocalDate startDate;
    private int duration;
    private Appointment appointment;
    private Physician physician;
    private Patient patient;
}
