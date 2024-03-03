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
        return ResponseEntity.ok(workerService.getWorkers());
    }

    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Worker> getWorkerById(@PathVariable BigInteger id) {
        Optional<Worker> worker = workerService.findWorkerById(id);
        if (worker.isPresent()) {
            return ResponseEntity.ok(worker.get());
        }
        else {
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
