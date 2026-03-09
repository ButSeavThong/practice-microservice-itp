package com.thongfazon.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountServiceApplication implements CommandLineRunner {

//	@Value("${STRONG_PASSWORD}")
//	private String strongPassword;

//	@Value("${WEEK_PASSWORD}")
//	private String weakPassword;

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("===== VAULT SECRETS FROM CONFIG SERVER =====");
//		System.out.println("STRONG_PASSWORD = " + strongPassword);
//		System.out.println("WEEK_PASSWORD   = " + weakPassword);
		System.out.println("===========================================");
	}
}
