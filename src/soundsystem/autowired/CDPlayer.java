package soundsystem.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

@Component
public class CDPlayer implements MediaPlayer {

	private CompactDisc cd;

	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	@Autowired
	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
	}

}
