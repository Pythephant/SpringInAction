package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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

import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.domain.Spitter;
import spittr.domain.Spittle;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	@Autowired
	private SpitterRepository spitterRepo;

	@Autowired
	private SpittleRepository spittleRepo;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
			@Valid Spitter spitter, HttpServletRequest request, HttpServletResponse response, Errors error)
			throws IllegalStateException, IOException, ServletException {
		if (error.hasErrors()) {
			// System.out.println("Post Parameter is not valid.");
			// System.out.println(error);
			return "registerForm";
		}
		if (!profilePicture.isEmpty()) {
			profilePicture.transferTo(new File(spitter.getUsername() + "_" + profilePicture.getOriginalFilename()));
		} else {
			// throw new MultipartMustNotEmptyException();
		}
		spitterRepo.save(spitter);
		// automatically to login
		// UsernamePasswordAuthenticationToken token = new
		// UsernamePasswordAuthenticationToken(spitter.getUsername(),
		// spitter.getPassword());
		// request.getSession();
		// token.setDetails(new WebAuthenticationDetails(request));
		// Authentication authUser = authenticatoinManager();
		request.logout();
		request.getSession();	//because the request.logout() will clean almost everything, so it's required to get a new session to automatically login
		request.login(spitter.getUsername(), spitter.getPassword());
		return "redirect:/spitter/" + spitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepo.findByUsername(username);
		if (spitter != null) {
			model.addAttribute(spitter);
		}
		model.addAttribute(new Spittle());
		model.addAttribute(spittleRepo.findSpittles());

		return "profile";
	}

	@ExceptionHandler(MultipartMustNotEmptyException.class)
	public String handleMultipartEmpty() {
		return "multipartEmpty";
	}
}
