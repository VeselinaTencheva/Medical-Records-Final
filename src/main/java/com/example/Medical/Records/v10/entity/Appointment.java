package com.example.Medical.Records.v10.entity;

import com.example.Medical.Records.v10.entity.physicians.Physician;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity{

    @Column(name = "date", nullable = false)
    @NotNull(message = "Date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be in the future or present")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "physician_id")
    @NotNull
    private Physician physician;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sickLeave_id", referencedColumnName = "id")
    private SickLeave sickLeave;

    @ManyToOne()
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

}
