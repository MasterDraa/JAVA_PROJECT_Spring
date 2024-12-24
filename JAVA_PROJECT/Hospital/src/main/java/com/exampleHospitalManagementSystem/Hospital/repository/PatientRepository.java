package com.exampleHospitalManagementSystem.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exampleHospitalManagementSystem.Hospital.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}

