package com.vishnugan.bookstore;

import org.springframework.boot.SpringApplication;// 2nd intha application lai main run akekai spring ai start panurathiku
//spring application
import org.springframework.boot.autoconfigure.SpringBootApplication; // 1st intha application ai run panrathuku
// spring boot application

@SpringBootApplication

public class StarterApp {
    public static void main(String[] args) {
        SpringApplication.run (StarterApp.class, args );// source and arguments
    }
}
