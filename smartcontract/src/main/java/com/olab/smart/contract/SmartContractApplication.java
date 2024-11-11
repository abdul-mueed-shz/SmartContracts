package com.olab.smart.contract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SmartContractApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartContractApplication.class, args);
    }

}
