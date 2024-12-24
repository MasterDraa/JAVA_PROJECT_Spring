package com.exampleHospitalManagementSystem.Hospital.service;

import com.exampleHospitalManagementSystem.Hospital.model.Medical_Record;
import com.exampleHospitalManagementSystem.Hospital.repository.MedicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Medical_RecordService {

    private final MedicalRecordRepository medicalRecordsRepository;

    // Add a new medical record
    public Medical_Record addMedicalRecord(Medical_Record medicalRecord) {
        if (medicalRecord == null) {
            throw new IllegalArgumentException("Medical record object cannot be null");
        }
        return medicalRecordsRepository.save(medicalRecord);
    }

    // Get a medical record by ID
    public Medical_Record getMedicalRecordById(Long id) {
        return medicalRecordsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Medical record with ID " + id + " not found"));
    }

    // Get all medical records
    public List<Medical_Record> getAllMedicalRecords() {
        return medicalRecordsRepository.findAll();
    }

    // Update a medical record by ID
    public Medical_Record updateMedicalRecord(Long id, Medical_Record updatedRecord) {
        return medicalRecordsRepository.findById(id).map(existingRecord -> {
            existingRecord.setDate_of_visit(updatedRecord.getDate_of_visit());
            existingRecord.setDiagnosis(updatedRecord.getDiagnosis());
            existingRecord.setPrescription(updatedRecord.getPrescription());
            existingRecord.setNotes(updatedRecord.getNotes());
            existingRecord.setPatient_id(updatedRecord.getPatient_id());
            existingRecord.setDoctor_id(updatedRecord.getDoctor_id());
            return medicalRecordsRepository.save(existingRecord);
        }).orElseThrow(() -> new IllegalArgumentException("Medical record with ID " + id + " not found"));
    }

    // Delete a medical record by ID
    public void deleteMedicalRecord(Long id) {
        if (!medicalRecordsRepository.existsById(id)) {
            throw new IllegalArgumentException("Medical record with ID " + id + " not found");
        }
        medicalRecordsRepository.deleteById(id);
    }
}
