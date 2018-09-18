package spittr.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.web.SpitterController;

public class SpitterControllerTest {

	@Test
	public void shouldShowRegisterForm() throws Exception {
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
				.andExpect(MockMvcResultMatchers.view().name("registerForm"));

	}
	

}
