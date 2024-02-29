package com.example.Project3_Basic_SpringBoot_JAR;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
@EnableCaching
public class Project3BasicSpringBootJarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project3BasicSpringBootJarApplication.class, args);
	}
}
