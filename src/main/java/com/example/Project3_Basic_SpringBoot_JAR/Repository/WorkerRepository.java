package com.example.Project3_Basic_SpringBoot_JAR.Repository;

import com.example.Project3_Basic_SpringBoot_JAR.Entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, BigInteger> {
}
