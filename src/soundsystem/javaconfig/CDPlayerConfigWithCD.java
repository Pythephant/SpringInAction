package soundsystem.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

@Configuration
public class CDPlayerConfigWithCD {
	@Bean
	public CompactDisc sgtPepper() {
		return new SgtPepper();
	}

	/*
	 * @Bean public CompactDisc hardNights() { return new HardNights(); }
	 */

	@Bean
	public CDPlayer cdPlayer(CompactDisc cd) {
		return new CDPlayer(cd);
	}

	


}
