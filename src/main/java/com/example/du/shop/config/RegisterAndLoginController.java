package com.example.du.shop.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.du.shop.auth.RoleRepository;
import com.example.du.shop.auth.UserDataForm;
import com.example.du.shop.auth.UserRepository;
import com.example.du.shop.generated.Role;
import com.example.du.shop.generated.ShopUser;

@Controller
public class RegisterAndLoginController {

	@Autowired
	UserRepository userService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	DaoAuthenticationProvider authProvider;

	@RequestMapping(value = { "/", "login", "login/{message}" }, method = RequestMethod.GET)
	public String loginGet(Model model, @PathVariable(required = false) String message) {
		if (message != null && !message.isEmpty())
			switch (message) {
			case "registered":
				model.addAttribute("registeredMessage", "true");
				break;
			case "wrongLogin":
				model.addAttribute("wrongLogin", "true");
				break;
			case "wrongPassword":
				model.addAttribute("wrongPassword", "true");
				break;
			}

		if (!model.containsAttribute("login"))
			model.addAttribute("login", new UserDataForm());
		return "login";
	}

	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
	public String loginPost(@ModelAttribute UserDataForm login, BindingResult result) {

		if (result.hasErrors())
			return "login";

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				login.getUsername(), login.getPassword());

		if (!userService.existsBySuLogin(login.getUsername())) {
			return "redirect:/login/wrongLogin";
		}

		try {
			Authentication resultAuthentication = authProvider.authenticate(authentication);
			if (resultAuthentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(resultAuthentication);
				return "redirect:/home";
			}
		} catch (BadCredentialsException e) {
			// empty
		}
		return "redirect:/login/wrongPassword";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("user", auth.getPrincipal());

		mav.setViewName("logout");
		return mav;
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String registerGet(Model model) {
		if (!model.containsAttribute("register"))
			model.addAttribute("register", new UserDataForm());
		return "register";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String registerPost(@ModelAttribute UserDataForm form, Model model, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("register", form);
			return "register";
		}

		if (!form.getPassword().equals(form.getPasswordRepeated())) {
			model.addAttribute("register", form);
			return "register";
		}

		Optional<ShopUser> userCheck = userService.findBySuLogin(form.getUsername());

		if (!userCheck.isPresent()) {
			ShopUser newShopUser = new ShopUser();
			newShopUser.setSuLogin(form.getUsername());
			newShopUser.setSuPassword(new SCryptPasswordEncoder().encode(form.getPassword()));
			newShopUser.setRoles(new HashSet<Role>(Arrays.asList(roleRepository.findByRlName("ROLE_USER"))));
			userService.save(newShopUser);

			return "redirect:/login/registered";
		} else
			return "register";
	}

}
