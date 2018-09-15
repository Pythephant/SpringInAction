package soundsystem.xmlconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import soundsystem.CompactDisc;

public class CDConfig {
	@Bean
	public CompactDisc blankDiscWithTracks() {
		List<String> tracks = new ArrayList<>();
		tracks.add("Lalala...");
		tracks.add("Bobobo...");
		tracks.add("Cicici...");
		return new BlankDiscWithTracks("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", tracks);
	}
}
