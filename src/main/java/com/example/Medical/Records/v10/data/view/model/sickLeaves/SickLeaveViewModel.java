package com.example.Medical.Records.v10.data.view.model.sickLeaves;

import com.example.Medical.Records.v10.data.entity.Appointment;
import com.example.Medical.Records.v10.data.entity.Patient;
import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SickLeaveViewModel {
    private long id;
    private LocalDate startDate;
    private int duration;
    private Patient patient;
    private Appointment appointment;
    private Physician physician;
}
