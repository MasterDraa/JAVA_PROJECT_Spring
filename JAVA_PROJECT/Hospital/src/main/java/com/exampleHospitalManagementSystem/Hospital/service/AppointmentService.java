package com.exampleHospitalManagementSystem.Hospital.service;

import com.exampleHospitalManagementSystem.Hospital.model.Appointment;
import com.exampleHospitalManagementSystem.Hospital.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // Add a new appointment
    public Appointment addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment object cannot be null");
        }
        return appointmentRepository.save(appointment);
    }

    // Get an appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + id + " not found"));
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Update an appointment by ID
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id).map(existingAppointment -> {
            existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
            existingAppointment.setDoctor(updatedAppointment.getDoctor());
            existingAppointment.setPatient(updatedAppointment.getPatient());
            existingAppointment.setStatus(updatedAppointment.getStatus());
            existingAppointment.setNotes(updatedAppointment.getNotes());
            return appointmentRepository.save(existingAppointment);
        }).orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + id + " not found"));
    }

    // Delete an appointment by ID
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Appointment with ID " + id + " not found");
        }
        appointmentRepository.deleteById(id);
    }
}
