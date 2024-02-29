package com.example.Project3_Basic_SpringBoot_JAR.Repository;

import com.example.Project3_Basic_SpringBoot_JAR.Entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
