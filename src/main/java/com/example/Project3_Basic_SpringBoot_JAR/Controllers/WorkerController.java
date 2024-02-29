package com.example.Project3_Basic_SpringBoot_JAR.Controllers;

import com.example.Project3_Basic_SpringBoot_JAR.Entities.Worker;
import com.example.Project3_Basic_SpringBoot_JAR.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("TEST");
    }
}
