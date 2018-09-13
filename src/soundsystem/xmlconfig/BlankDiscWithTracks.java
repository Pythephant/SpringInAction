package soundsystem.xmlconfig;

import java.util.List;

import soundsystem.CompactDisc;

public class BlankDiscWithTracks implements CompactDisc {

	private String title;
	private String artist;
	private List<String> tracts;

	public BlankDiscWithTracks(String title, String artist, List<String> tracts) {
		this.title = title;
		this.artist = artist;
		this.tracts = tracts;
	}

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		for (String tract : tracts)
			System.out.println("---Tract:" + tract);
	}

}
