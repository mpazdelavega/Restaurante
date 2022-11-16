package com.restaurante.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mercadopago.MercadoPagoConfig;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		MercadoPagoConfig.setAccessToken("TEST-4053818643951438-111417-f5a67bdcb0a3f94a3be0e173ea54a61f-1237981482");
	}

}
