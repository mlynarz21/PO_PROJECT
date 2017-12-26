package com.StoreX;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.persistence.repository.impl.BilansRepositoryImpl;
import com.StoreX.service.BilansService;
import com.StoreX.service.impl.BilansServ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

@SpringBootApplication
public class StoreXApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreXApplication.class, args);

		System.out.println("Uwaga");


	}
}
