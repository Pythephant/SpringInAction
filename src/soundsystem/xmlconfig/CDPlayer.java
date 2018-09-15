package soundsystem.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/soundsystem/config/soundsystem.xml");
		MediaPlayer player = context.getBean(MediaPlayer.class);
		player.play();
	}

}
