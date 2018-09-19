package advanced.wiring.getPropertiesFromEnv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ExpressiveConfig.class })
public class ExpressiveTest {

	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private BlankDisc cd;

	@Test
	public void testGetPropertiesFromFile() {
		cd.play();
		assertEquals(
				"Playing Sgt. Peppers Lonely Hearts Club Band by The Beatles Whoo" + System.getProperty("line.separator"),
				log.getLog());
	}
}
