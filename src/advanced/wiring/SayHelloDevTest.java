package advanced.wiring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SayHelloConfig.class })
@ActiveProfiles("dev")
public class SayHelloDevTest {

	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private SayHello sayer;

	@Test
	public void testHelloDev() {
		sayer.sayHello();
		assertEquals("Hello, Dev" + System.getProperty("line.separator"), log.getLog());
	}

}
