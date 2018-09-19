package advanced.wiring.placeholder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PlaceholderConfig.class })
public class PlaceholderTest {

	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private BlankDiscWithPlaceholder cd;

	@Test
	public void testPlaceholder() {
		cd.play();
		assertEquals("Playing Place Holder is wonderful by Jason" + System.getProperty("line.separator"), log.getLog());
	}

}
