package com.archer.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public final class CalculatorController {
    /**
     *
     */
    @Autowired
    private Calculator calculator;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") final Integer a,
               @RequestParam("b") final Integer b) {
        return String.valueOf(calculator.sum(a, b));
    }
}
