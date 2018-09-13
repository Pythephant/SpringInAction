package soundsystem.xmlconfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/soundsystem/config/soundsystem.xml" })
public class CDPlayerWithBlankDiscTest {
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
		// assertEquals("SgtPepper is being
		// played..."+System.getProperty("line.separator"), log.getLog());
	}

	@Test
	public void cdPlayerTest() {
		player.play();
		assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles"
				+ System.getProperty("line.separator") + "---Tract:Lalala..." + System.getProperty("line.separator")
				+ "---Tract:Bobobo..." + System.getProperty("line.separator") + "---Tract:Cicici..."
				+ System.getProperty("line.separator"), log.getLog());
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/soundsystem/config/soundsystem.xml");
		MediaPlayer cdp = context.getBean(MediaPlayer.class);
		cdp.play();
	}
}
