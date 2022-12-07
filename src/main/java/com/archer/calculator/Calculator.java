package com.archer.calculator;

import org.springframework.stereotype.Service;

/** have to.
 * ##
 */
@Service
public class Calculator {
    /** have to.
     *
     * @param a
     * @param b
     * @return the sum of a and b
     */
    public int sum(final int a, final int b) {
        return  a + b;
    }
}
