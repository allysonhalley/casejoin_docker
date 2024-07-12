package com.hemti.casejoin;

import org.springframework.boot.SpringApplication;

public class TestCasejoinApplication {

    public static void main(String[] args) {
        SpringApplication.from(CasejoinApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
