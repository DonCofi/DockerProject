package com.example.Project3_Basic_SpringBoot_JAR.Controllers;

import com.example.Project3_Basic_SpringBoot_JAR.Entities.Worker;
import com.example.Project3_Basic_SpringBoot_JAR.Service.WorkerService;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.certpath.OCSPResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Worker>>  getAllWorkers (){
        System.out.println("USAO U GET ALL");
        return ResponseEntity.ok(workerService.getWorkers());
    }

    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Worker> getWorkerById(@PathVariable BigInteger id) {
        System.out.println("USAO U GET ID");
        Optional<Worker> worker = workerService.findWorkerById(id);
        if (worker.isPresent()) {
            System.out.println("NASAO");
            return ResponseEntity.ok(worker.get());
        }
        else {
            System.out.println("NIJE NASAO");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable BigInteger id){
        Optional<Worker> worker = workerService.findWorkerById(id);
        if (!worker.isPresent())
            return ResponseEntity.notFound().build();
        workerService.removeWorker(id);
        return ResponseEntity.ok().build();
    }
}
