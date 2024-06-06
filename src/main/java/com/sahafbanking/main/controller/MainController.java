package com.sahafbanking.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sahafbanking.main.model.entity.AdminLogin;
import com.sahafbanking.main.model.entity.User;
import com.sahafbanking.main.model.entity.UserLogin;
import com.sahafbanking.main.service.UserServicesImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	UserServicesImpl userServices;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		System.out.println("Test");
		return modelAndView;
	}

	@GetMapping("/application")
	public String applicationForm(Model m) {
		System.out.println("Opening form");
		String[] countryCodes = Locale.getISOCountries();
		List<String> countries = new ArrayList<String>();
		for (String countryCode : countryCodes) {
			Locale obj = new Locale("", countryCode);
			countries.add(obj.getDisplayCountry());
		}
		List<String> branches = new ArrayList<String>();
		branches.add("Pune");
		branches.add("Mumbai");
		branches.add("Not Applicable");
		List<String> accounts = new ArrayList<String>();
		accounts.add("Saving Account");
		accounts.add("Current Account");
		accounts.add("Fixed Deposite");
		List<String> salutations = new ArrayList<String>();
		salutations.add("Mr");
		salutations.add("Miss");
		salutations.add("Mrs");
		List<String> genders = new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		genders.add("Others");

		m.addAttribute("countries", countries);
		m.addAttribute("branches", branches);
		m.addAttribute("accounts", accounts);
		m.addAttribute("salutations", salutations);
		m.addAttribute("genders", genders);
		m.addAttribute("user", new User());
		System.out.println("Test");
		return "application-form";
	}

	@PostMapping("/application")
	public String processForm(@Valid @ModelAttribute("user") User user, BindingResult br, Model m) {
		System.out.println(br);
		String[] countryCodes = Locale.getISOCountries();
		List<String> countries = new ArrayList<String>();
		for (String countryCode : countryCodes) {
			Locale obj = new Locale("", countryCode);
			countries.add(obj.getDisplayCountry());
		}
		List<String> branches = new ArrayList<String>();
		branches.add("Pune");
		branches.add("Mumbai");
		branches.add("Not Applicable");
		List<String> accounts = new ArrayList<String>();
		accounts.add("Saving Account");
		accounts.add("Current Account");
		accounts.add("Fixed Deposite");
		List<String> salutations = new ArrayList<String>();
		salutations.add("Mr");
		salutations.add("Miss");
		salutations.add("Mrs");
		List<String> genders = new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		genders.add("Others");

		m.addAttribute("countries", countries);
		m.addAttribute("branches", branches);
		m.addAttribute("accounts", accounts);
		m.addAttribute("salutations", salutations);
		m.addAttribute("genders", genders);
		if (br.hasErrors()) {
			System.out.println(br);
			return "application-form";
		}

		else { 
			if(userServices.authenticate(user)) {
				userServices.saveUser(user);
				user = null;
			    m.addAttribute("success_message", "Application Sucessfully!"); 
			    return "application-form";
			} else {
				m.addAttribute("error_message", "Mobile number is already use!! Please try applying using another mobile number"); 
				return "application-form";
			} 
		}

	}
	@GetMapping("/admin/login")
	public String adminLogin(Model m) {
		System.out.println("Test");
		m.addAttribute("login", new AdminLogin());
		return "admin/pages-login";
	}
	@PostMapping("/admin/login")
	public String loginProcess(@Valid @ModelAttribute("login") AdminLogin login, BindingResult bindingresult, Model m, HttpSession session) {
		System.out.println(bindingresult);
		if(bindingresult.hasErrors()) {
			System.out.println(login);
			m.addAttribute("error_message", "Please provide correct details!");
			return "admin/pages-login";
		}
		else {
			System.out.println(login);
			if(userServices.loginVerification(login)) {
				System.out.println(userServices.getAdminDetail(login));
				m.addAttribute("admindetail", userServices.getAdminDetail(login));
				session.setAttribute("admindetail", userServices.getAdminDetail(login));
				return "admin/index";
			}
			else {
				m.addAttribute("error_message", "Email or Password doesn't match! Please provide correct details or register.");
				return "admin/pages-login";
			}
		}
		
	}
	@GetMapping("/admin/logout")
	public String logoutAdminProfile(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/";
	}
	@GetMapping("/user/login")
	public String userLogin(Model m) {
		System.out.println("Test");
		m.addAttribute("userLogin", new UserLogin());
		return "user/pages-login";
	}
	@PostMapping("/user/login")
	public String userLoginProcess(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult bindingresult, Model m, HttpSession session) {
		System.out.println(bindingresult);
		if(bindingresult.hasErrors()) {
			System.out.println(userLogin);
			m.addAttribute("error_message", "Please provide correct details!");
			return "user/pages-login";
		}
		else {
			System.out.println(userLogin);
			if(userServices.userLoginVerification(userLogin)) {
				System.out.println(userServices.getUserDetail(userLogin));
				m.addAttribute("userdetail", userServices.getUserDetail(userLogin));
				session.setAttribute("userdetail", userServices.getUserDetail(userLogin));
				return "user/index";
			}
			else {
				m.addAttribute("error_message", "Email or Password doesn't match! Please provide correct details or register.");
				return "user/pages-login";
			}
		}
		
	}
	@GetMapping("/user/logout")
	public String logoutUserProfile(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/";
	}

}
