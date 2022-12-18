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
  //  @Cacheable("sum")
    public int sum(final int a, final int b) {
       /* try {
            Thread.sleep(REST);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return  a + b;
    }
}
