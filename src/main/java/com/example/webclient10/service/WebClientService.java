package com.example.webclient10.service;

import com.example.webclient10.model.Region;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService {

    private WebClient regionClient;

    public WebClientService() {
        regionClient = WebClient
                .builder()
                .baseUrl("")
                .build();
    }

    //Kalder smitte backend med ekstra parameter, nemlig trådnavn. Bruges til at nogle tråde bliver sat til at vente
    public Region fetchRegionSleep(String threadName) {
        Region region = regionClient.get()
                .uri("http://localhost:5000/regionsleep/1081/" + threadName)
                .retrieve()
                .bodyToMono(Region.class)
                .block();

        return region;
    }


    //Den her virker. Henter helt almindelig 1 region. Virker også selvom Region har counties. Bare nogle af de variable der er i Region Json er her i Region.
    public Region fetchRegion() {
        Region region = regionClient.get()
                .uri("http://localhost:5000/region/1081")
                .retrieve()
                .bodyToMono(Region.class)
                .block();

        return region;
    }


}
