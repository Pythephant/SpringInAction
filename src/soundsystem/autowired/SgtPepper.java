package soundsystem.autowired;

import org.springframework.stereotype.Component;

import soundsystem.CompactDisc;

@Component("lonelyPepper")
public class SgtPepper implements CompactDisc {

	@Override
	public void play() {
		System.out.println("SgtPepper is being played...");
	}

}
