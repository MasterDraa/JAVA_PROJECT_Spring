package com.exampleHospitalManagementSystem.Hospital.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "patients")
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(unique = true ,name = "Email", nullable = false)
    private String email;

    @Column(unique = true ,name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "address", nullable = false)
    private String address;






}
