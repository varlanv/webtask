package com.example.webtask.services;

public class CoefficientValidator {

    public static void validate(Double a, Double b, Double c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("All fields have to be specified");
        }
    }
}
