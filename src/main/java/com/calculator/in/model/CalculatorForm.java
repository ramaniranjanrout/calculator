package com.calculator.in.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorForm {
    private double number1;
    private double number2;
    private String operation;
    private double result;

}
