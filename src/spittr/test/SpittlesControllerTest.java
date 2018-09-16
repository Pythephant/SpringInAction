package spittr.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.Spittle;
import spittr.data.SpittleRepository;

public class SpittlesControllerTest {

	public void shouldShowCurrentSpittles() {
		List<Spittle> expectedSpittleList = createSpittleList(20);
		SpittleRepository mockRepository = ;
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittleList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittleList.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittleList;
	}

}
