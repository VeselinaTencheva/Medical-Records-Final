package com.example.Medical.Records.v10.data.view.model.appointments;

import com.example.Medical.Records.v10.data.entity.Diagnosis;
import com.example.Medical.Records.v10.data.entity.Patient;
import com.example.Medical.Records.v10.data.entity.SickLeave;
import com.example.Medical.Records.v10.data.entity.Treatment;
import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentViewModel {

//    Appointment Data
    private LocalDate date;

    private long id;

    private Patient patient;

    private Physician physician;

    private Diagnosis diagnosis;

    private Treatment treatment;

    private SickLeave sickLeave;

}
