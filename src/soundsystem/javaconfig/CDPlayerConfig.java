package soundsystem.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

@Configuration
// @Import(CDConfig.class)
@ImportResource("META-INF/soundsystem/config/sgtpepper.xml")
public class CDPlayerConfig {

	/*
	 * @Bean public CompactDisc hardNights() { return new HardNights(); }
	 */

	@Bean
	public CDPlayer cdPlayer(CompactDisc cd) {
		return new CDPlayer(cd);
	}

}
