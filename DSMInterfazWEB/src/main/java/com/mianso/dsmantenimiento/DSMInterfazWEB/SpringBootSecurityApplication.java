package com.mianso.dsmantenimiento.DSMInterfazWEB;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootSecurityApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootSecurityApplication.class, args);
//    }
}