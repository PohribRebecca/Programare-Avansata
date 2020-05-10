package com.example.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Demo3Application.class, args);
		System.out.println("rebecca");


	}

}
