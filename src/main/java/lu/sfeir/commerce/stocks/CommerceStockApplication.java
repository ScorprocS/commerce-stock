package lu.sfeir.commerce.stocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CommerceStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceStockApplication.class, args);
	}

}
