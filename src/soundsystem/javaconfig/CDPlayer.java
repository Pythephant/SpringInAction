package soundsystem.javaconfig;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

public class CDPlayer implements MediaPlayer {

	private CompactDisc cd;

	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
		System.out.println("reset the cd again");
	}

	@Override
	public void play() {
		cd.play();
	}

}
