package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	@Autowired
	private SpitterRepository spitterRepo;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
			@Valid Spitter spitter, Errors error) throws IllegalStateException, IOException {
		if (error.hasErrors()) {
			// System.out.println("Post Parameter is not valid.");
			// System.out.println(error);
			return "registerForm";
		}
		if (!profilePicture.isEmpty()) {
			profilePicture.transferTo(new File(spitter.getUsername() + "_" + profilePicture.getOriginalFilename()));
		} else {
			throw new MultipartMustNotEmptyException();
		}
		spitterRepo.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepo.findByUsername(username);
		if (spitter != null) {
			model.addAttribute(spitter);
		}
		return "profile";
	}
	
	@ExceptionHandler(MultipartMustNotEmptyException.class)
	public String handleMultipartEmpty() {
		return "multipartEmpty";
	}
}
