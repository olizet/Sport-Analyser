package com.sportsDataAnlyze.dataReplicator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class DataReplicatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataReplicatorApplication.class, args);
	}

}

