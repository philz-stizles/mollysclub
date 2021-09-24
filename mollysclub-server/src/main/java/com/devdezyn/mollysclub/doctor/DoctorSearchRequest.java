package com.devdezyn.mollysclub.doctor;

import java.util.Optional;

import lombok.Data;

@Data
public class DoctorSearchRequest {
    Optional<Integer> page;
    Optional<Integer> size;
    private String search;
}
