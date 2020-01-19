package guru.springframework.springbootbrewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan("guru.springframework.springbootbrewery")
public class SpringBootBreweryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBreweryApplication.class, args);
	}

}
