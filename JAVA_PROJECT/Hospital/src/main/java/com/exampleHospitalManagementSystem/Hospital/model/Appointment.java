package com.exampleHospitalManagementSystem.Hospital.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Table(name = "appointments")
@Entity

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_patient"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_doctor"))
    private Doctor doctor;



}
