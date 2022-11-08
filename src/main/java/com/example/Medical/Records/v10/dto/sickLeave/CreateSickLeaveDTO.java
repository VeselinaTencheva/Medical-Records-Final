package com.example.Medical.Records.v10.dto.sickLeave;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateSickLeaveDTO {
    private LocalDate startDate;
    private int duration;
//    private Appointment appointment;
}
