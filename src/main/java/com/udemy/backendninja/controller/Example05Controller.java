package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constants.ViewsConstant;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example05")
public class Example05Controller {

	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/")
	public String index() {
		return "redirect:/example05/post/string";
	}
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/post/string")
	public String requestStrPost( Model model ) {
		model.addAttribute("person", new Person());
		model.addAttribute("result", "");
		return ViewsConstant.EXAMPLE05;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@PostMapping("/post/addPerson")
	public ModelAndView requestMavPost(@ModelAttribute("person") Person person ) {
		ModelAndView mav = new ModelAndView(ViewsConstant.EXAMPLE05);
		mav.addObject("person",person);
		mav.addObject("result", "Se ha recibo la información");
		return mav;
	}
	
}
