package com.exampleHospitalManagementSystem.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exampleHospitalManagementSystem.Hospital.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}




