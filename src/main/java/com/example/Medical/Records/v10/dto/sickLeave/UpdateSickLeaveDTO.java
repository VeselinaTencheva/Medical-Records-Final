package com.example.Medical.Records.v10.dto.sickLeave;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateSickLeaveDTO {
    private LocalDate startDate;
    private int duration;
//    private Appointment appointment;
}
