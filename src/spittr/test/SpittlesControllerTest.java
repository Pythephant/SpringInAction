package spittr.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.internal.matchers.IsCollectionContaining;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.data.SpittleRepository;
import spittr.domain.Spittle;
import spittr.web.SpittleController;

public class SpittlesControllerTest {

	@Test
	public void shouldShowCurrentSpittles() throws Exception {
		// using the Mockito package to mock the Interface SpittleRepository to return
		// the SpittleList
		List<Spittle> expectedSpittleList = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles()).thenReturn(expectedSpittleList);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
				.andExpect(MockMvcResultMatchers.view().name("spittles"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
				.andExpect(MockMvcResultMatchers.model().attribute("spittleList",
						IsCollectionContaining.hasItems(expectedSpittleList.toArray())));

	}

	@Test
	public void showPagedSpittles() throws Exception {
		List<Spittle> expectedList = createSpittleList(50);
		SpittleRepository mockSpitlleRepo = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockSpitlleRepo.findSpittles()).thenReturn(expectedList);

		SpittleController controller = new SpittleController(mockSpitlleRepo);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

		mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=239800&count=50"))
				.andExpect(MockMvcResultMatchers.view().name("spittles"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList")).andExpect(MockMvcResultMatchers
						.model().attribute("spittleList", IsCollectionContaining.hasItems(expectedList.toArray())));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittleList = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			spittleList.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittleList;
	}

}
