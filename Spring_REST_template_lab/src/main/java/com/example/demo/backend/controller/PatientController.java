package com.example.demo.backend.controller;

import com.example.demo.backend.domain.Patient;
import com.example.demo.backend.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/backend/patient")
public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    private ResponseEntity<String> printValidError(Errors errors) {
        FieldError field = errors.getFieldErrors().get(0);
        return new ResponseEntity<>(field.getField() + ": " +
                field.getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> findAll() {
        log.info("GET request for a list of patients");
        List<Patient> patients = patientService.findAll();
        return new ResponseEntity<>(patients, patients.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> find(@PathVariable Long id) {
        log.info("GET request for a patient with id " + id);
        Patient patient = patientService.find(id);
        if (patient == null) {
            log.info("Patient with id " + id + " not found");
        }
        return new ResponseEntity<>(patient, patient == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody @Valid Patient patient, Errors errors) {
        log.info("POST request for creation " + patient);
        if (errors.hasErrors()) {
            log.info("Patient not valid");
            return printValidError(errors);
        }
        Long patient_id = patientService.savePatient(patient).getId();
        log.info("Patient created with id " + patient_id);
        return ResponseEntity.ok("Patient created with id " + patient_id);
    }
}
