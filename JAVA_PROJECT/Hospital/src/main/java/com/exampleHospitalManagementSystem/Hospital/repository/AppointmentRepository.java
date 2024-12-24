package com.exampleHospitalManagementSystem.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exampleHospitalManagementSystem.Hospital.model.Appointment;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
