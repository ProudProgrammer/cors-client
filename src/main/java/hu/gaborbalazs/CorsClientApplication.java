package hu.gaborbalazs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class CorsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsClientApplication.class, args);
	}
}
