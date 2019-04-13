package com.sportsDataAnlyze.remoteconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class RemoteConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemoteConfigServerApplication.class, args);
	}

}
