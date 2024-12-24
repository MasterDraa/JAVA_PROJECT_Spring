package com.exampleHospitalManagementSystem.Hospital.service;

import com.exampleHospitalManagementSystem.Hospital.model.Doctor;
import com.exampleHospitalManagementSystem.Hospital.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    // Add a new doctor
    public Doctor addDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor object cannot be null");
        }
        return doctorRepository.save(doctor);
    }

    // Delete a doctor by ID
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new IllegalArgumentException("Doctor with ID " + id + " not found.");
        }
        doctorRepository.deleteById(id);
    }

    // Update doctor details
    public Doctor updateDoctor(Doctor updatedDoctor, Long id) {
        if (updatedDoctor == null) {
            throw new IllegalArgumentException("Updated Doctor object cannot be null");
        }

        return doctorRepository.findById(id).map(existingDoctor -> {
            existingDoctor.setFirst_name(updatedDoctor.getFirst_name());
            existingDoctor.setLast_name(updatedDoctor.getLast_name());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setExperience(updatedDoctor.getExperience());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setContact_number(updatedDoctor.getContact_number());
            return doctorRepository.save(existingDoctor);
        }).orElseThrow(() -> new IllegalArgumentException("Doctor with ID " + id + " not found."));
    }

    // Get a doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor with ID " + id + " not found."));
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
