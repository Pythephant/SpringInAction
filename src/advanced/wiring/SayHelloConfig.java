package advanced.wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SayHelloConfig {

	@Bean(name = "helloDev")
	@Profile("dev")
	public SayHello hiDev() {
		return new HelloDev();
	}

	@Bean
	@Profile("prod")
	public SayHello helloProd() {
		return new HelloProd();
	}
}
