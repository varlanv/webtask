package com.example.webtask.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "coefficients_id")
    private Coefficients coefficients;
    private double firstX;
    private double secondX;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getFirstX() {
        return firstX;
    }

    public void setFirstX(double firstX) {
        this.firstX = firstX;
    }

    public double getSecondX() {
        return secondX;
    }

    public void setSecondX(double secondX) {
        this.secondX = secondX;
    }

    public Coefficients getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Coefficients coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id.equals(result.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Result{" +
                "firstX=" + firstX +
                ", secondX=" + secondX +
                '}';
    }
}

