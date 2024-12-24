package com.exampleHospitalManagementSystem.Hospital.Controller;

import com.exampleHospitalManagementSystem.Hospital.model.Medical_Record;
import com.exampleHospitalManagementSystem.Hospital.service.Medical_RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical_records")
@RequiredArgsConstructor
public class Medical_RecordController {

    private final Medical_RecordService medicalRecordsService;

    // Add a new medical record
    @PostMapping("/add")
    public ResponseEntity<Medical_Record> addMedicalRecord(@RequestBody Medical_Record medicalRecord) {
        try {
            Medical_Record savedRecord = medicalRecordsService.addMedicalRecord(medicalRecord);
            return new ResponseEntity<>(savedRecord, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Get a medical record by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Medical_Record> getMedicalRecordById(@PathVariable Long id) {
        try {
            Medical_Record medicalRecord = medicalRecordsService.getMedicalRecordById(id);
            return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get all medical records
    @GetMapping("/all")
    public ResponseEntity<List<Medical_Record>> getAllMedicalRecords() {
        try {
            List<Medical_Record> medicalRecords = (List<Medical_Record>) medicalRecordsService.getAllMedicalRecords();
            return new ResponseEntity<>(medicalRecords, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a medical record
    @PutMapping("/update/{id}")
    public ResponseEntity<Medical_Record> updateMedicalRecord(@PathVariable Long id, @RequestBody Medical_Record updatedRecord) {
        try {
            Medical_Record medicalRecord = medicalRecordsService.updateMedicalRecord(id, updatedRecord);
            return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a medical record
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable Long id) {
        try {
            medicalRecordsService.deleteMedicalRecord(id);
            return new ResponseEntity<>("Medical record deleted successfully.", HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
