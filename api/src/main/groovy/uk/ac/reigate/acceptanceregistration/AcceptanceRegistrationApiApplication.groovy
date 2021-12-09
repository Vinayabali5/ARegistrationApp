package uk.ac.reigate.acceptanceregistration

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@EntityScan(basePackages = "uk.ac.reigate.domain")
class AcceptanceRegistrationApiApplication {

	static void main(String[] args) {
		SpringApplication.run(AcceptanceRegistrationApiApplication, args)
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
					.addMapping("/**")
					//.allowCredentials(true)
					.allowedOrigins("*")
					.allowedMethods("*");
			}
		};
	}

}
