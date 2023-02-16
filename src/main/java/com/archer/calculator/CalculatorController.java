package com.archer.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/sum", method = RequestMethod.POST, consumes = "application/json")
    String sum(@RequestBody Adder adder) {
        return String.valueOf(adder.apply());
    }
}
