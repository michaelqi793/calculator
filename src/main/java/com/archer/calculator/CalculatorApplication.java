package com.archer.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * i have to put a doc here.
 * ##
 */

@SpringBootApplication
//@EnableCaching
public class CalculatorApplication {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }


   /*
   @Bean
   public ClientConfig hazelcastClientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("hazelcast");
        return clientConfig;

    }*/

}
