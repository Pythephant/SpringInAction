package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;
import spittr.domain.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	// the trick to create the Max Long String in compile time, as a constant
	private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) Long max,
			@RequestParam(value = "count", defaultValue = "20") int count, Model model) {
		model.addAttribute(spittleRepository.findSpittles(max, count));
		return "spittles";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showSpittle(@RequestParam(value = "spittle_id") long spittleId, Model model) {

		addSpittleToModel(model, spittleRepository.findOne(spittleId));
		return "spittle";
	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable long spittleId, Model model) {
		addSpittleToModel(model, spittleRepository.findOne(spittleId));
		return "spittle";
	}

	private void addSpittleToModel(Model model, Spittle spittle) {
		if (spittle == null)
			throw new SpittleNotFoundException();
		model.addAttribute(spittle);
	}
}
