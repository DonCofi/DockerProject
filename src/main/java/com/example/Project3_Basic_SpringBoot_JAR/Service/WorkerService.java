package com.example.Project3_Basic_SpringBoot_JAR.Service;

import com.example.Project3_Basic_SpringBoot_JAR.Entities.Worker;
import com.example.Project3_Basic_SpringBoot_JAR.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getWorkers (){ return (List<Worker>) workerRepository.findAll(); }

    public Optional<Worker> findWorkerById (BigInteger id) {return workerRepository.findById(id);}

    public void removeWorker(BigInteger id) {workerRepository.deleteById(id);}
}
