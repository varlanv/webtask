package com.example.webtask.controllers;

import com.example.webtask.domain.Result;
import com.example.webtask.exceptions.NoSolutionException;
import com.example.webtask.services.SquareEquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class EquationController {

    private SquareEquationService squareEquationService;

    @Autowired
    public EquationController(SquareEquationService squareEquationService) {
        this.squareEquationService = squareEquationService;
    }

    public EquationController() {
    }

    @RequestMapping(value = "/equation", method = POST)
    public ModelAndView calculate(@RequestParam("a") Double a,
                                  @RequestParam("b") Double b,
                                  @RequestParam("c") Double c) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        try {
            Result result = squareEquationService.calculateAndSave(a, b, c);
            modelAndView.addObject("response", "First x = " + result.getFirstX() + "\n" + "Second x = " + result.getSecondX());
            return modelAndView;

        } catch (NoSolutionException ex) {
            modelAndView.addObject("response", ex.getMessage());
            return modelAndView;
        } catch (IllegalArgumentException ex) {
            modelAndView.addObject("response", ex.getMessage());
        }
        return modelAndView;
    }
}