package com.exampleHospitalManagementSystem.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exampleHospitalManagementSystem.Hospital.model.Medical_Record;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<Medical_Record, Long> {
}



