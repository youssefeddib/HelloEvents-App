package org.example.helloeventsapp;

import org.example.helloeventsapp.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloEventsAppApplication implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(HelloEventsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        roleService.createDefaultRoles();
    }
}
