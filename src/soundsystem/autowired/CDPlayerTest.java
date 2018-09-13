package soundsystem.autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private CompactDisc cd;

	@Autowired
	private MediaPlayer player;

	@Test
	public void cdIsNotNullTest() {
		assertNotNull(cd);
	}

	@Test
	public void cdPlayerTest() {
		player.play();
		assertEquals("SgtPepper is being played...\n", log.getLog());
	}

}
