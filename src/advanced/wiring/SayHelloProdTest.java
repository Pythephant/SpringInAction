package advanced.wiring;

import static org.junit.Assert.assertEquals;

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
@ActiveProfiles("prod")
public class SayHelloProdTest {

	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private SayHello sayer;

	@Test
	public void sayHelloProd() {
		sayer.sayHello();
		assertEquals("Hello, Production" + System.getProperty("line.separator"), log.getLog());
	}
}
