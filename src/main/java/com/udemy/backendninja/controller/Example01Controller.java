package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constants.ViewsConstant;

@Controller
@RequestMapping("/example01")
public class Example01Controller {
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/string")
	public String example01String() {
		return ViewsConstant.EXAMPLE01;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@RequestMapping(value="/mav" , method=RequestMethod.GET)
	public ModelAndView example01MAV() {
		return new ModelAndView(ViewsConstant.EXAMPLE01);
	}
}
