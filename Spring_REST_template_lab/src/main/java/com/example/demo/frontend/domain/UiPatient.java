package com.example.demo.frontend.domain;

import lombok.Data;
import lombok.Setter;

@Data
public class UiPatient {
    @Setter
    private String fullName;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
