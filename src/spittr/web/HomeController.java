package spittr.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping({ "/", "/homepage" })
public class HomeController {

	@RequestMapping(method = GET)
	public String home() {
		return "home";
	}

	// @RequestMapping(method = GET, value = "/login")
	// public String login() {
	// return "login";
	// }

	// @RequestMapping(value = "/logout", method = GET)
	// public String logout(HttpServletRequest request, HttpServletResponse
	// response) {
	// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	// if (auth != null) {
	// new SecurityContextLogoutHandler().logout(request, response, auth);
	// }
	// return "home";
	// }
}
