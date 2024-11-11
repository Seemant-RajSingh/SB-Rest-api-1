package com.srs.REST.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestApiApplication implements CommandLineRunner {
//	ProdDB prodDB;
	@Autowired // calls AppConfig beans
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	// cmdRunner + run => start as soon as app starts
	@Override
	public void run(String... args) throws Exception {
//		db = new ProdDB();     // not preferred method
		System.out.println(db.getData());
	}
}
