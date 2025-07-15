package com.calculator.in.controller;

import com.calculator.in.model.CalculatorForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculator(Model model) {
        model.addAttribute("calculatorForm", new CalculatorForm());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute CalculatorForm form, Model model) {
        double result = 0;

        switch (form.getOperation()) {
            case "add":
                result = form.getNumber1() + form.getNumber2();
                break;
            case "subtract":
                result = form.getNumber1() - form.getNumber2();
                break;
            case "multiply":
                result = form.getNumber1() * form.getNumber2();
                break;
            case "divide":
                if (form.getNumber2() != 0) {
                    result = form.getNumber1() / form.getNumber2();
                } else {
                    model.addAttribute("error", "Cannot divide by zero.");
                }
                break;
        }

        form.setResult(result);
        model.addAttribute("calculatorForm", form);
        return "index";
    }
}
