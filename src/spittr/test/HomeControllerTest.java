package spittr.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.web.HomeController;

public class HomeControllerTest {
	@Test
	public void testHomePage() {
		HomeController controller = new HomeController();
		assertEquals("home", controller.home());
	}

	@Test
	public void testHomePageWithMock() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
	}
}
