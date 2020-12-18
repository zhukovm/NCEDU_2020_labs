package com.example.demo.frontend.service;

import com.example.demo.backend.domain.Patient;
import com.example.demo.frontend.builder.PatientBuilder;
import com.example.demo.frontend.domain.UiPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties(prefix = "backend")
public class UiPatientService {
    private final RestTemplate restTemplate;
    private final PatientBuilder patientBuilder;
    private String server;
    private String port;

    @Autowired
    public UiPatientService(PatientBuilder patientBuilder) {
        this.restTemplate = new RestTemplate();
        this.patientBuilder = patientBuilder;
    }

    public List<UiPatient> getAllUiPatient() {
        Patient[] uiPatients = restTemplate.getForEntity(server + ":" + port + "/backend/patient/all", Patient[].class)
                .getBody();
        return Arrays.asList(uiPatients).stream().map(patient -> patientBuilder.decode(patient)).collect(Collectors.toList());
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
