package com.example.demo.frontend.builder;

import com.example.demo.backend.domain.Patient;
import com.example.demo.frontend.domain.UiPatient;
import org.springframework.stereotype.Service;

@Service
public class PatientBuilder implements Builder<Patient, UiPatient> {

    @Override
    public Patient encode(UiPatient uiPatient) {
        Patient p = new Patient();
        p.setName(uiPatient.getFullName().split("/")[1]);
        p.setMiddleName(uiPatient.getFullName().split("/")[2]);
        p.setSurname(uiPatient.getFullName().split("/")[3]);
        return p;
    }

    @Override
    public UiPatient decode(Patient patient) {
        UiPatient uiPatient = new UiPatient();
        uiPatient.setFullName(patient.getName() + "/" + patient.getMiddleName() + "/" + patient.getSurname());
        return uiPatient;
    }
}
