package com.example.demo.backend.service;

import com.example.demo.backend.domain.Patient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("test")
public class MockPatientServiceImpl implements PatientService {

    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Patient find(Long id) {
        Patient p = new Patient();
        p.setId(1L);
        p.setName("MockName");
        p.setSurname("MockSurname");
        return p;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return null;
    }
}
