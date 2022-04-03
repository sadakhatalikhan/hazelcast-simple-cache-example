package com.sb.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelcastSimplecacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastSimplecacheExampleApplication.class, args);
	}

}
