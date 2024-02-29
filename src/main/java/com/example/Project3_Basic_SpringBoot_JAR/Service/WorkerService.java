package com.example.Project3_Basic_SpringBoot_JAR.Service;

import com.example.Project3_Basic_SpringBoot_JAR.Entities.Worker;
import com.example.Project3_Basic_SpringBoot_JAR.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getWorkers (){
        return workerRepository.findAll();
    }
}
