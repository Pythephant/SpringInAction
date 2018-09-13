package soundsystem.javaconfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CDPlayerConfig.class})
public class CDPlayerTest {
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private CompactDisc cd;

	@Autowired
	private CDPlayer player;

	@Test
	public void cdIsNotNullTest() {
		assertNotNull(cd);
		// cd.play();
		// assertEquals("SgtPepper is being played...\n", log.getLog());
	}

	@Test
	public void cdPlayerTest() {
		player.play();
		player.setCompactDisc(cd);
		assertEquals("SgtPepper is being played..." + System.getProperty("line.separator") + "reset the cd again"
				+ System.getProperty("line.separator"), log.getLog());
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfigWithCD.class);
		CompactDisc cd = context.getBean(CompactDisc.class);
		MediaPlayer cdPlayer = context.getBean(MediaPlayer.class);
		cd.play();
		cdPlayer.play();
	}

}
