package soundsystem.javaconfig;

import org.springframework.context.annotation.Bean;

import soundsystem.CompactDisc;

public class CDConfig {
	@Bean
	public CompactDisc sgtPepper() {
		return new SgtPepper();
	}
}
