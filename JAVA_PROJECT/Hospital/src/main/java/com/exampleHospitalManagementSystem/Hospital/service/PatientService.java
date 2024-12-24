package com.exampleHospitalManagementSystem.Hospital.service;

import com.exampleHospitalManagementSystem.Hospital.model.Patient;
import com.exampleHospitalManagementSystem.Hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    // Add a new patient
    public Patient addPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient object cannot be null");
        }
        return patientRepository.save(patient);
    }

    // Delete a patient by ID
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Patient with ID " + id + " not found");
        }
        patientRepository.deleteById(id);
    }

    // Update a patient by ID
    public Patient updatePatient(Long id, Patient updatedPatient) {
        if (updatedPatient == null) {
            throw new IllegalArgumentException("Updated patient object cannot be null");
        }


        return patientRepository.findById(id).map(existingPatient -> {
            existingPatient.setFirst_name(updatedPatient.getFirst_name());
            existingPatient.setLast_name(updatedPatient.getLast_name());
            existingPatient.setAge(updatedPatient.getAge());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setPhone_number(updatedPatient.getPhone_number());
            existingPatient.setAddress(updatedPatient.getAddress());

            return patientRepository.save(existingPatient);
        }).orElseThrow(() -> new IllegalArgumentException("Patient with ID " + id + " not found"));
    }

    // Get a patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient with ID " + id + " not found"));
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
