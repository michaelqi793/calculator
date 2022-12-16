package com.archer.calculator;

import com.hazelcast.client.config.ClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * i have to put a doc here.
 * ##
 */

@SpringBootApplication
@EnableCaching
public class CalculatorApplication {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    /**
     *
     * @return the hazelcast cleintconfig used by the spring cache framework
     */
    @Bean
    public ClientConfig hazelcastClientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("hazelcast");
        return clientConfig;

    }

}
