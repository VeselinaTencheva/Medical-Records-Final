package com.example.Medical.Records.v10.data.view.model.sickLeaves;

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
}
