package advanced.wiring.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import soundsystem.CompactDisc;

@Component
public class BlankDiscWithPlaceholder implements CompactDisc {

	@Value("${placeholder.title}")
	private String title;
	@Value("${placeholder.artist}")
	private String artist;

	public BlankDiscWithPlaceholder() {
	}

	public BlankDiscWithPlaceholder(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
