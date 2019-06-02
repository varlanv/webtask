package com.example.webtask.services;

import com.example.webtask.domain.Result;
import com.example.webtask.exceptions.NoSolutionException;
import com.example.webtask.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquareEquationService {

    private ResultRepository resultRepository;

    @Autowired
    public SquareEquationService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public SquareEquationService() {
    }

    public void save(Result result) {
        resultRepository.save(result);
    }

    public Result calculateAndSave(Double a, Double b, Double c) {
        Result result = calculateDiscriminant(a, b, c);
        resultRepository.save(result);
        return result;
    }

    public Result calculateDiscriminant(Double a, Double b, Double c) {
        CoefficientValidator.validate(a, b, c);
        Result result = new Result();

        double d = b * b - (4 * a * c);

        if (d == 0) {
            result.setFirstX((-b) / (2 * a));
            result.setSecondX(result.getFirstX());

        } else if (d > 0) {
            result.setFirstX((-b + Math.sqrt(d)) / (2 * a));
            result.setSecondX((-b - Math.sqrt(d)) / (2 * a));
        } else {
            throw new NoSolutionException("No solution for:" + " a=" + a + ", b=" + b + ", c=" + c);
        }
        return result;
    }
}
