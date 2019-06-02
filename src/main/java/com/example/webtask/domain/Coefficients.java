package com.example.webtask.domain;

import javax.persistence.*;

@Entity
@Table(name = "coefficients")
public class Coefficients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double a;
    private double b;
    private double c;

    public Coefficients() {
    }

    public Coefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}

