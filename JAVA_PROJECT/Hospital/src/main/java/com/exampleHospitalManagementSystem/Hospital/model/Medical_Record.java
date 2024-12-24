package com.exampleHospitalManagementSystem.Hospital.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Table(name = "medical_records")
@Entity

public class Medical_Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "patient_id", nullable = false)
    private Long patient_id;
    @Column(name = "doctor_id", nullable = false)
    private Long doctor_id;

    @Column(name = "date_of_visit", nullable = false)
    private LocalDate date_of_visit;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @Column(name = "prescription", nullable = false)
    private String prescription;

    @Column(name = "notes", nullable = false)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Doctor doctor;
}
