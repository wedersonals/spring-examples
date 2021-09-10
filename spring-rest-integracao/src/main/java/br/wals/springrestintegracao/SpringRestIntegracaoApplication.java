package br.wals.springrestintegracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringRestIntegracaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestIntegracaoApplication.class, args);
	}

}
