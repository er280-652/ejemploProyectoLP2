package com.ciberfarma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ciberfarma.dto.AutentacionFilter;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("filter", new AutentacionFilter());
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if (session.getAttribute("idUsuario") == null) {
			return "redirect:/login/iniciar-sesion";
		}
		
		return "dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
