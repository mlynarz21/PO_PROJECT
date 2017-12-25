package com.StoreX;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.PozycjaBilansu;
import com.StoreX.persistence.repository.BilansRepository;
import com.StoreX.persistence.repository.UserRepository;
import com.StoreX.persistence.repository.impl.BilansRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreXApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreXApplication.class, args);

		BilansRepository b = new BilansRepositoryImpl();
		System.out.println("Uwaga");
		System.out.println(b.getMissingBalanceDates().toString());

		Bilans bilans = new Bilans();
		PozycjaBilansu pb = new PozycjaBilansu();



	}
}
