package advanced.wiring.getPropertiesFromEnv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import soundsystem.CompactDisc;

@Configuration
@PropertySource("classpath:/advanced/wiring/blankdisc.properties")
public class ExpressiveConfig {

	@Autowired
	Environment env;

	@Bean
	public BlankDisc disc() {
		return new BlankDisc(env.getProperty("disc.title"), env.getProperty("disc.artist"));
	}

}
