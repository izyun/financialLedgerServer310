package com.example.financialLedgerServer310;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.financialLedgerServer310"})
@SpringBootApplication
public class FinancialLedgerServer310Application {

	public static void main(String[] args) {
		SpringApplication.run(FinancialLedgerServer310Application.class, args);
	}

}
