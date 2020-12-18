package com.example.demo.backend.service;

import com.example.demo.backend.domain.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    Patient find(Long id);

    Patient savePatient(Patient patient);

}
