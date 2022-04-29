package com.example.webclient10.controller;

import com.example.webclient10.model.MyThread;
import com.example.webclient10.model.Region;
import com.example.webclient10.repository.RegionRepository;
import com.example.webclient10.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RegionRESTController {

    @Autowired
    WebClientService webClientService;

    @Autowired
    RegionRepository regionRepository;

    Region region = null;

    @GetMapping("/threads")
    public List<MyThread> getAllThreads() {
        ArrayList<MyThread> mtList = new ArrayList<>();
        Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
        MyThread mt2 = new MyThread();
        mt2.setStateName("Antal="+threads.size());
        mtList.add(mt2);

        for (Thread t: threads.keySet()) {
            MyThread mt = new MyThread();
            mt.setThreadName(t.getName());
            System.out.println(t.getName());
            mt.setStateName(t.getState().name());
            mt.setState(t.getState().toString());
            mtList.add(mt);
        }
        return mtList;

    }

    @GetMapping("/insertsleep/{id}")
    public ResponseEntity<Region> insertRegionsSleep(@PathVariable Integer id) {
        String threadName = Thread.currentThread().getName();
        System.out.println("TRÅD=" + threadName);

        for (int i = 0; i<id; i++) {
            region = webClientService.fetchRegionSleep(threadName);
            if (!region.getName().isEmpty()) {
                region.setSavedTm(LocalTime.now());
                region.setSavedTmMilli("" + LocalTime.now().getNano());
                region.setThreadName(threadName);
                regionRepository.save(region);
            }

        }
        return new ResponseEntity<>(region, HttpStatus.OK);
    }


    @GetMapping("/insert/{id}")
    public ResponseEntity<Region> insertRegions(@PathVariable Integer id) {
        String threadName = Thread.currentThread().getName();
        System.out.println("TRÅD=" + threadName);

        for (int i = 0; i<id; i++) {
            region = webClientService.fetchRegion();
            if (!region.getName().isEmpty()) {
                region.setSavedTm(LocalTime.now());
                region.setSavedTmMilli("" + LocalTime.now().getNano());
                region.setThreadName(threadName);
                regionRepository.save(region);
            }


        }
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

}
