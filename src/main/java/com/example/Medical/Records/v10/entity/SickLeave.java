package com.example.Medical.Records.v10.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sick_leave")
public class SickLeave extends BaseEntity{

    @Column(name = "start_date", nullable = false)
    @NotNull(message = "Start Date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Start Date must be in the future or present")
    private LocalDate startDate;

    @Column(name = "duration", nullable = false)
    @NotNull(message = "- Error: Duration days is mandatory")
    @Positive(message = "- Error: Duration days cannot be negative")
    private int duration;

    @OneToOne(mappedBy = "sickLeave", cascade = CascadeType.ALL)
    private Appointment appointment;

}
