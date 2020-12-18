package com.example.demo.frontend.controller;

import com.example.demo.frontend.domain.UiPatient;
import com.example.demo.frontend.service.UiPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ui")
public class UiController {

    @Autowired
    UiPatientService uiPatientService;

    @GetMapping("/patients/all")
    public ResponseEntity<List<UiPatient>> findAll() {
        List<UiPatient> uiPatients = uiPatientService.getAllUiPatient();
        return new ResponseEntity<>(uiPatients, HttpStatus.OK);
    }
}
