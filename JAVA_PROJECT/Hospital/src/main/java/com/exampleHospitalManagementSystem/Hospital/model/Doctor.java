package com.exampleHospitalManagementSystem.Hospital.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table (name = "doctors")
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @Column(unique = true , name = "email", nullable = false)
    private String email;

    @Column(unique = true , name = "contact_number", nullable = false)
    private String contact_number;




}
