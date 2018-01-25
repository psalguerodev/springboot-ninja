package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constants.ViewsConstant;

@Controller
@RequestMapping("/example02")
public class Example02Controller {

	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/string")
	public String param01String(Model  model) {
		model.addAttribute("name", "Patrick Armando Salguero Avalos - String");
		return ViewsConstant.EXAMPLE02;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@GetMapping("/mav")
	public ModelAndView param01MAV() {
		ModelAndView mav =  new ModelAndView(ViewsConstant.EXAMPLE02);
		mav.addObject("name","Patrick Salguero - MAV");
		return mav;
	}
	
}
