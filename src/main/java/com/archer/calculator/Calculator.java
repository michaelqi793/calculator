package com.archer.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/** have to.
 * ##
 */
@Service
public class Calculator {

    /**
     * have to.
     */
    public static final long REST = 3000L;

    /** have to.
     *
     * @param a
     * @param b
     * @return the sum of a and b
     */

    public int sum(final int a, final int b) {
        try {
            Thread.sleep(REST);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  a + b;
    }
}
