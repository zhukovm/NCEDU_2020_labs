package com.example.demo.backend.service;

import com.example.demo.backend.domain.Patient;
import com.example.demo.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("!test")
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient find(Long id) {
        return patientRepository.findPatientById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

}
