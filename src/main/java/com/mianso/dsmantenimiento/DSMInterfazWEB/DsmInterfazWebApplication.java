package com.mianso.dsmantenimiento.DSMInterfazWEB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DsmInterfazWebApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DsmInterfazWebApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DsmInterfazWebApplication.class);
	}

}
