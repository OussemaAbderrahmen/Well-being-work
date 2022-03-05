package tn.esprit.spring.wecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc

public class WeCareBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeCareBackApplication.class, args);
	}

}
