package com.example.webclient10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebClient10Application {

    public static void mainwebclient() {
        String json = WebClient.create()
                .get()
                .uri("http://localhost:5000/region/1081")
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();
        System.out.println(json);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebClient10Application.class, args);
        mainwebclient();
    }

}
