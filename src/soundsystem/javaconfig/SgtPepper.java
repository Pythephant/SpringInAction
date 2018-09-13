package soundsystem.javaconfig;

import org.springframework.stereotype.Component;

import soundsystem.CompactDisc;

public class SgtPepper implements CompactDisc {

	@Override
	public void play() {
		System.out.println("SgtPepper is being played...");
	}

}
